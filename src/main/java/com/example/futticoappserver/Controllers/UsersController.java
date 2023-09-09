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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/Users")
public class UsersController {
    @Autowired
    private UserProfilesServices users_service;

    @GetMapping("/GetAllUsersProfiles")
    @ResponseBody
    public ResponseEntity<List<UsersProfiles>> GetAllUsers() {
        return new ResponseEntity<>(users_service.GetAllCurrentProfiles(), HttpStatus.OK);

    }

    @GetMapping("/SearchByRolType/{rol}")
    public ResponseEntity<List<UsersProfiles>> GetAllUsersProfilesByRol(@PathVariable("rol") String rol) {

        if (users_service.SearchUsersByRolType(rol).size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<UsersProfiles>>(users_service.SearchUsersByRolType(rol), HttpStatus.OK);
    }

    @PostMapping("/NewUserProfile")
    public ResponseEntity<?> PostUser(@RequestBody UsersProfiles user) throws Exception {

        try {
            if (user.getUserAccount() != "" || user.getUserRol() != "") {
                return new ResponseEntity<>("REGISTERED", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("INFORMACION INVALIDA,VERIFIQUE LA INFORMACION ENVIADA",
                        HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/UpdateProfile")
    public UsersProfiles PutUser(@RequestBody UsersProfiles update) {
        return users_service.UpdateCurrentProfile(update);
    }

    @DeleteMapping("/DeleteProfile/{id}")
    public String DeleteProfile(@PathVariable("id") String id) {
        return users_service.DeleteProfileSelected(id);
    }

}
