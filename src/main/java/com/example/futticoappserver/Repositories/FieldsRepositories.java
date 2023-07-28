package com.example.futticoappserver.Repositories;

import com.example.futticoappserver.Models.Fields;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldsRepositories extends MongoRepository <Fields,String> {
    @Query("{fieldName:'?0'}")
    List<Fields> FilterByLocationField(String fieldName);

}
