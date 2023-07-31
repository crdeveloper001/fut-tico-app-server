package com.example.futticoappserver.Controllers;

import com.example.futticoappserver.Models.Fields;
import com.example.futticoappserver.Services.FieldsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/v1/Fields")
public class FieldsController {

    @Autowired
    private FieldsServices field_service;

    @GetMapping("/GetAllField")
    @ResponseBody
    public ResponseEntity<List<Fields>> GetAllFields(){
        return new ResponseEntity<>(field_service.GetAllCurrentFields(), HttpStatus.OK);

    }
    @GetMapping("/SearchByLocation/{location}")
    public List<Fields> GetAllFieldsLocation(@PathVariable("location") String location){
        return field_service.SearchFieldByLocation(location);
    }
    @PostMapping("/NewField")
    public Fields PostField(@RequestBody Fields field){
        return field_service.AddNewField(field);
    }
    @PutMapping("/UpdateField")
    public Fields PutField(@RequestBody Fields update){
        return field_service.UpdateCurrentField(update);
    }
    @DeleteMapping("/DeleteField/{id}")
    public String DeleteField(@PathVariable("id") String id){
        return field_service.DeleteFieldSelected(id);
    }


}
