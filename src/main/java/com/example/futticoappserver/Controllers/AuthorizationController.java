package com.example.futticoappserver.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.futticoappserver.Models.UsersProfiles;
import com.example.futticoappserver.Services.AuthorizationServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/Authorization")
public class AuthorizationController {

    @Autowired
    private AuthorizationServices authorization_Services;

    @PostMapping({ "/AuthenticateProfile" })
    public ResponseEntity<?> PostUserAuth(@RequestBody UsersProfiles userAccount) {

        UsersProfiles payload = authorization_Services.AuthorizeProfile(userAccount.getUserAccount(),
                userAccount.getUserAccountPassword());

        switch (payload.getUserJwt()) {
            case "INVALIDE_ACCOUNT":
                return new ResponseEntity<>(payload, HttpStatus.OK);
            case "AUTHORIZE":
                return new ResponseEntity<>(payload, HttpStatus.OK);

            default:
                return new ResponseEntity<>("ERROR INSIDE SERVER, PLEASE WAIT A WHILE AND TRY AGAIN",
                        HttpStatus.BAD_GATEWAY);

        }

    }

}
