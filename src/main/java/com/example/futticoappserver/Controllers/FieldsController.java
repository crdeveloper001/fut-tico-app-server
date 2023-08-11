package com.example.futticoappserver.Controllers;

import com.example.futticoappserver.Models.Fields;
import com.example.futticoappserver.Services.FieldsServices;
import com.google.common.io.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/SearchByLocation/{location}")
    public ResponseEntity<List<Fields>> GetAllFieldsLocation(@PathVariable("location") String location) {

        if (field_service.SearchFieldByLocation(location).size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } 
         return new ResponseEntity<List<Fields>>(field_service.SearchFieldByLocation(location), HttpStatus.OK);
    };

    @PostMapping("/NewField")
    public Fields PostField(@RequestBody Fields field) {
        return field_service.AddNewField(field);
    }
    @PostMapping("/UploadFieldImage")
    public String handleFileUpload(@RequestParam("file") MultipartFile file ) {
        // ...

        try {
            // Get the resource for the "temp-uploads" directory
            ClassPathResource resource = new ClassPathResource("temp-uploads/");
            Files uploadPath = resource.getFile();

            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            File uploadedFile = new File(uploadPath.getAbsolutePath() + "/" + file.getOriginalFilename());
            file.transferTo(uploadedFile);

            // ...
        } catch (IOException e) {
            // ...
        }

        return "uploadForm";

    @PutMapping("/UpdateField")
    public Fields PutField(@RequestBody Fields update) {
        return field_service.UpdateCurrentField(update);
    }

    @DeleteMapping("/DeleteField/{id}")
    public String DeleteField(@PathVariable("id") String id) {
        return field_service.DeleteFieldSelected(id);
    }

}
