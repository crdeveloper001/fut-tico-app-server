package com.example.futticoappserver.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.futticoappserver.Interfaces.IAuthorization;
import com.example.futticoappserver.Models.UsersProfiles;
import com.example.futticoappserver.Repositories.AuthenticationRepositories;

@Service
public class AuthorizationServices implements IAuthorization {

    @Autowired
    private AuthenticationRepositories usersRepositories;

    @Override
    public UsersProfiles AuthorizeProfile(String account, String password) {
        UsersProfiles UserPayload = new UsersProfiles();

        try {
            // buscar usuario especifico
            UsersProfiles CurrentProfile = new UsersProfiles();
            CurrentProfile = usersRepositories.SearchUserProfileInformation(account);

            // If Current profile does not contain information from the search, will return
            // a empty message with id of not found
            if (CurrentProfile == null) {

                UserPayload.setUserJwt("ACCOUNT NAME DOES NOT MATCH OR PASSWORD INCORRECT");
                return UserPayload;
            }
            // compare account and password with the current profile found successfull
            if (account.equals(CurrentProfile.getUserAccount())
                    && password.equals(CurrentProfile.getUserAccountPassword())) {

                UserPayload.setId(CurrentProfile.getId());
                UserPayload.setUserName(CurrentProfile.getUserName());
                UserPayload.setUserLastName(CurrentProfile.getUserLastName());
                UserPayload.setUserPhone(CurrentProfile.getUserPhone());
                UserPayload.setUserEmail(CurrentProfile.getUserEmail());
                UserPayload.setUserAccount(CurrentProfile.getUserAccount());
                UserPayload.setUserRol(CurrentProfile.getUserRol());
                UserPayload.setUserJwt(CurrentProfile.getUserJwt());
                UserPayload.setUserActive(true);
                return UserPayload;

            }

           UserPayload.setUserJwt("ACCOUNT NAME DOES NOT MATCH OR PASSWORD INCORRECT");
            return UserPayload;
        } catch (Exception error) {
            throw error;
        }

    }

}
