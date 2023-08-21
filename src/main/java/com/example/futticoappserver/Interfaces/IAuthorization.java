package com.example.futticoappserver.Interfaces;

import com.example.futticoappserver.Models.UsersProfiles;

public interface IAuthorization {
    
    UsersProfiles AuthorizeProfile(String account, String password);
    
}
