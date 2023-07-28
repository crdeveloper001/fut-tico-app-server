package com.example.futticoappserver.Services;

import com.example.futticoappserver.Interfaces.IFields;
import com.example.futticoappserver.Models.Fields;
import com.example.futticoappserver.Repositories.FieldsRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FieldsServices implements IFields {

    @Autowired
    private FieldsRepositories field_repositories;

    public FieldsServices(FieldsRepositories _repositories) {
        this.field_repositories = _repositories;
    }

    @Override
    public List<Fields> GetAllCurrentFields() {

        return  field_repositories.findAll();
    }

    @Override
    public List<Fields> SearchFieldByLocation(String location) {
        return field_repositories.FilterByLocationField(location);
    }

    @Override
    public Fields AddNewField(Fields field) {

        try{
            if (field != null){
                field.setId(UUID.randomUUID().toString());
                field_repositories.save(field);
                return field;
            }

            return null;
        }catch (Exception error){
            throw error;
        }
    }
    @Override
    public Fields UpdateCurrentField(Fields update) {

        try{

            if (field_repositories.existsById(update.getId())) {
                field_repositories.save(update);
                return update;
            } else if (!field_repositories.existsById(update.getId())) {
                return null;
            }else {
                return null;
            }
        }catch (Exception error){
            throw error;
        }
    }

    @Override
    public String DeleteFieldSelected(String fieldId) {

        try{
            if (field_repositories.existsById(fieldId)) {
                field_repositories.deleteById(fieldId);
                return "Campo de futbol eliminado";
            } else if (!field_repositories.existsById(fieldId)) {
                return "Campo de futbol no existe!";
            }else{
                return "No se pudo eliminar o el campo no existe";
            }
        }catch (Exception error){
            return error.getMessage();
        }
    }
}
