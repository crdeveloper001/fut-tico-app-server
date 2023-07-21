package com.example.futticoappserver.Services;

import com.example.futticoappserver.Interfaces.IUsersProfiles;
import com.example.futticoappserver.Models.UsersProfiles;
import com.example.futticoappserver.Repositories.TournamentsRepositories;
import com.example.futticoappserver.Repositories.UsersProfilesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfilesServices implements IUsersProfiles {

    private UsersProfilesRepositories repositories;

    @Override
    public List<UsersProfiles> GetAllCurrentProfiles() {
       return repositories.findAll();
    }

    @Override
    public List<UsersProfiles> SearchTournamentsByRol(String rol) {
        return repositories.FilterByRol(rol);
    }

    @Override
    public UsersProfiles AddNewProfiles(UsersProfiles profile) {
        try{
            if (repositories.existsById(profile.getUserId())) {
                profile.setUserId(UUID.randomUUID().toString());
                repositories.saveAndFlush(profile);
                return profile;
            }else if(!repositories.existsById(profile.getUserId())){
                return null;
            }else{
                return null;
            }
        }catch (Exception error){
            throw error;
        }
    }

    @Override
    public UsersProfiles UpdateCurrentProfile(UsersProfiles update) {
        try{
            if (repositories.existsById(update.getUserId())) {
                repositories.saveAndFlush(update);
                return update;
            }else if(!repositories.existsById(update.getUserId())){
                return null;
            }else{
                return null;
            }
        }catch (Exception error){
            throw error;
        }
    }

    @Override
    public String DeleteProfileSelected(String profileId) {
        try{
            if (repositories.existsById(profileId)) {
                repositories.deleteById(profileId);
                return "Usuario Eliminado";
            }else if(!repositories.existsById(profileId)){
                return "Usuario no existe";
            }else{
                return "No se pudo eliminar el usuario o no existe";
            }
        }catch (Exception error){
            return error.getMessage();
        }
    }
}
