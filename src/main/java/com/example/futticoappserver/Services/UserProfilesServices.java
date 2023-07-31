package com.example.futticoappserver.Services;

import com.example.futticoappserver.Interfaces.IUsersProfiles;
import com.example.futticoappserver.Models.UsersProfiles;
import com.example.futticoappserver.Repositories.UsersProfilesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfilesServices implements IUsersProfiles {

    @Autowired
    private UsersProfilesRepositories repositories;

    @Override
    public List<UsersProfiles> GetAllCurrentProfiles() {
        return repositories.findAll();
    }

    @Override
    public List<UsersProfiles> SearchUsersByRolType(String userRol) {
        return repositories.FilterByRol(userRol);
    }

    @Override
    public UsersProfiles AddNewProfiles(UsersProfiles profile) throws Exception {
        try{
           if (profile.equals(null) || profile.getId().equals("")) {
            profile.setId(UUID.randomUUID().toString());
                repositories.save(profile);
                return profile;
           }else{
            throw new Exception("DATOS INVALIDOS");
           }
        }catch (Exception error){
            throw error;
        }
    }

    @Override
    public UsersProfiles UpdateCurrentProfile(UsersProfiles update) {
        try {
            if (repositories.existsById(update.getId())) {
                repositories.save(update);
                return update;
            } else if (!repositories.existsById(update.getId())) {
                return null;
            } else {
                return null;
            }
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public String DeleteProfileSelected(String profileId) {
        try {
            if (repositories.existsById(profileId)) {
                repositories.deleteById(profileId);
                return "Usuario Eliminado";
            } else if (!repositories.existsById(profileId)) {
                return "Usuario no existe";
            } else {
                return "No se pudo eliminar el usuario o no existe";
            }
        } catch (Exception error) {
            return error.getMessage();
        }
    }
}
