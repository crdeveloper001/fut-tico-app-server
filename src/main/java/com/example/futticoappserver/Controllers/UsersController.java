package com.example.futticoappserver.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.futticoappserver.Models.UsersProfiles;
import com.example.futticoappserver.Services.UserProfilesServices;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/v1/Users")
public class UsersController {
    @Autowired
    private UserProfilesServices users_service;

    @GetMapping("/GetAllUsersProfiles")
    @ResponseBody
    public ResponseEntity<List<UsersProfiles>> GetAllUsers(){
        return new ResponseEntity<>(users_service.GetAllCurrentProfiles(), HttpStatus.OK);

    }
    @GetMapping("/SearchByRolType/{rol}")
    public List<UsersProfiles> GetAllUsersProfilesByRol(@PathVariable("rol") String rol){
        return users_service.SearchUsersByRolType(rol);
    }
    @PostMapping("/NewUserProfile")
    public UsersProfiles PostUser(@RequestBody UsersProfiles user) throws Exception{
        return users_service.AddNewProfiles(user);
    }
    @PutMapping("/UpdateProfile")
    public UsersProfiles PutUser(@RequestBody UsersProfiles update){
        return users_service.UpdateCurrentProfile(update);
    }
    @DeleteMapping("/DeleteProfile/{id}")
    public String DeleteProfile(@PathVariable("id") String id){
        return users_service.DeleteProfileSelected(id);
    }

}
