package com.example.futticoappserver.Repositories;

import com.example.futticoappserver.Models.Fields;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FieldsRepositories extends MongoRepository <Fields,String> {
    @Query("{fieldLocation:'?0'}")
    List<Fields> FilterByLocationField(String fieldLocation);

}
