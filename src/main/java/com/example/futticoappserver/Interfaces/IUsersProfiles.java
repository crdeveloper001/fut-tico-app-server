package com.example.futticoappserver.Interfaces;

import com.example.futticoappserver.Models.Tournaments;
import com.example.futticoappserver.Models.UsersProfiles;

import java.util.List;

public interface IUsersProfiles {

    List<UsersProfiles> GetAllCurrentProfiles();
    List<UsersProfiles> SearchTournamentsByRol(String rol);
    UsersProfiles AddNewProfiles(UsersProfiles profile);
    UsersProfiles UpdateCurrentProfile(UsersProfiles update);
    String DeleteProfileSelected(String profileId);
}
