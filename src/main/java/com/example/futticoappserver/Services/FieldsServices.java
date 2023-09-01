package com.example.futticoappserver.Services;

import com.example.futticoappserver.Interfaces.IFields;
import com.example.futticoappserver.Models.Fields;
import com.example.futticoappserver.Repositories.FieldsRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.UUID;

@Service
public class FieldsServices implements IFields {

    @Autowired
    private final FieldsRepositories service;

    FieldsServices(FieldsRepositories service) {
        this.service = service;
    }

    @Override
    public List<Fields> GetAllCurrentFields() {

        return service.findAll();
    }

    @Override
    public List<Fields> SearchFieldByLocation(String location) {
        return service.FilterByLocationField(location);
    }

    @Override
    public List<Fields> SearchFieldByGameType(String gameType) {
        return service.FilterByGameType(gameType);
    }
     @Override
    public List<Fields> SearchFieldByName(String fieldName) {
        String normalizedSearch = Normalizer.normalize(fieldName, Form.NFD);
        return service.FilterByName(normalizedSearch);
    }
 

    @Override
    public Fields AddNewField(Fields field) {

        try {
            if (field != null) {
                field.setId(UUID.randomUUID().toString());
                service.save(field);
                return field;
            }

            return null;
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public Fields UpdateCurrentField(Fields update) {

        try {

            if (service.existsById(update.getId())) {
                service.save(update);
                return update;
            } else if (!service.existsById(update.getId())) {
                return null;
            } else {
                return null;
            }
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public String DeleteFieldSelected(String fieldId) {

        try {
            if (service.existsById(fieldId)) {
                service.deleteById(fieldId);
                return "Campo de futbol eliminado";
            } else if (!service.existsById(fieldId)) {
                return "Campo de futbol no existe!";
            } else {
                return "No se pudo eliminar o el campo no existe";
            }
        } catch (Exception error) {
            return error.getMessage();
        }
    }

   

}
