package com.example.futticoappserver.Repositories;

import com.example.futticoappserver.Models.Fields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldsRepositories extends JpaRepository<Fields,String> {
    @Query("select f from Fields where f.fieldLocation = :location")
    List<Fields> FilterByLocationField(String location);
}
