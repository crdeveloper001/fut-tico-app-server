package com.example.futticoappserver.Repositories;

import com.example.futticoappserver.Models.UsersProfiles;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersProfilesRepositories extends MongoRepository<UsersProfiles,String> {
    @Query("{userRol:'?0'}")
    List<UsersProfiles> FilterByRol(String userRol);
    
}
