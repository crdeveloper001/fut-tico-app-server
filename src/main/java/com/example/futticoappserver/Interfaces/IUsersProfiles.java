package com.example.futticoappserver.Interfaces;


import com.example.futticoappserver.Models.UsersProfiles;

import java.util.List;

public interface IUsersProfiles {

    List<UsersProfiles> GetAllCurrentProfiles();
    List<UsersProfiles> SearchUsersByRolType(String rol);
    UsersProfiles AddNewProfiles(UsersProfiles profile) throws Exception;
    UsersProfiles UpdateCurrentProfile(UsersProfiles update);
    String DeleteProfileSelected(String profileId);
}
