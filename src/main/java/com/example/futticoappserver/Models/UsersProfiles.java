package com.example.futticoappserver.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "UserProfiles")
public class UsersProfiles {

    @Id
    private String id;
    private String userName;
    private String userLastName;
    private Integer userPhone;
    private String userEmail;
    private String userAccount;
    private String userAccountPassword;
    private String userRol;
    private boolean userActive;

}
