package com.example.futticoappserver.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.futticoappserver.Models.UsersProfiles;

public interface AuthenticationRepositories extends MongoRepository<UsersProfiles,String> {
     @Query("{userAccount : ?0}")
    UsersProfiles SearchUserProfileInformation(String userAccount);
}
