package com.example.futticoappserver.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Users_Profiles")
public class UsersProfiles {
    @Id
    @Column(name = "User_id")
    private String userId;

    @Column(name = "User_lastName")
    private String userLastName;

    @Column(name = "User_phone")
    private Integer userPhone;

    @Column(name = "User_email")
    private String userEmail;

    @Column(name = "User_password")
    private String userPassword;

    @Column(name = "User_rol")
    private String userRol;
    @jakarta.persistence.Id
    private Long id;



}
