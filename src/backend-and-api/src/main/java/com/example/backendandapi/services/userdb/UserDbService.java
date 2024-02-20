package com.example.backendandapi.services.userdb;

import com.example.backendandapi.models.dbentities.UserDbEntity;
import com.example.backendandapi.models.requests.ModifyAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDbService {
    UserDbRepository repository;

    @Autowired
    public UserDbService(UserDbRepository repository) {
        this.repository = repository;
    }

    public void addUser(UserDbEntity newUser) {
        repository.save(newUser);
    }

    public UserDbEntity getUser(String username) {
        return repository.findByUsernameNativeQuery(username);
    }

    public void modifyUser(ModifyAccountRequest modifiedAccount) {
        UserDbEntity requestedUser = getUser(modifiedAccount.getOldUsername());

        requestedUser.setUsername(modifiedAccount.getNewUsername());
        requestedUser.setProfilePictureURL(modifiedAccount.getProfilePictureURL());
        requestedUser.setAbout_me(modifiedAccount.getAbout_me());
        requestedUser.setPassword(modifiedAccount.getNewPassword());

        repository.save(requestedUser);
    }

    public UserDbEntity findUserById(Long id) {
        return repository.findUserById(id);
    }

    public Long findIdByUsername(String username) {
        return repository.findIdByUsername(username);
    }
}
