package com.example.futticoappserver.Controllers;

import com.example.futticoappserver.Models.Fields;
import com.example.futticoappserver.Services.FieldsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/Fields")
public class FieldsController {

    @Autowired
    private FieldsServices field_service;

    @GetMapping("/GetAllField")
    @ResponseBody
    public ResponseEntity<List<Fields>> GetAllFields() {
        return new ResponseEntity<>(field_service.GetAllCurrentFields(), HttpStatus.OK);

    }

    @SuppressWarnings("null")
    @GetMapping("/SearchByLocation/{location}")
    public ResponseEntity<List<Fields>> GetAllFieldsLocation(@PathVariable("location") String location) {

        if (field_service.SearchFieldByLocation(location).size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Fields>>(field_service.SearchFieldByLocation(location), HttpStatus.OK);
    };

    @SuppressWarnings("null")
    @GetMapping("/SearchByGameType/{gameType}")
    public ResponseEntity<List<Fields>> GetAllFieldsByGameType(@PathVariable("gameType") String gameType) {

        if (field_service.SearchFieldByGameType(gameType).size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Fields>>(field_service.SearchFieldByGameType(gameType), HttpStatus.OK);
    };

    @GetMapping("/SearchByName/{fieldName}")
    public ResponseEntity<?> GetAllFieldsByName(@PathVariable("fieldName") String fieldName) {

        if (field_service.SearchFieldByName(fieldName).size() == 0) {
            return new ResponseEntity<>("cancha no encontrada", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Fields>>(field_service.SearchFieldByName(fieldName), HttpStatus.OK);
    };

    @PostMapping("/NewField")
    public Fields PostField(@RequestBody Fields field) {
        return field_service.AddNewField(field);
    }

    @PutMapping("/UpdateField")
    public Fields PutField(@RequestBody Fields update) {
        return field_service.UpdateCurrentField(update);
    }

    @DeleteMapping("/DeleteField/{id}")
    public String DeleteField(@PathVariable("id") String id) {
        return field_service.DeleteFieldSelected(id);
    }

}
