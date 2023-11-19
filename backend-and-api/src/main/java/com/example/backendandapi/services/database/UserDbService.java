package com.example.backendandapi.services.database;

import com.example.backendandapi.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserDbService {
    DbRepositoryInterface dbRepository;
    HashMap<String, User> users;

    @Autowired
    public UserDbService(DbRepositoryInterface dbRepository) {
        this.dbRepository = dbRepository;
        this.users = new HashMap<>();
        getAllUsers();
    }

    public void addUser(User newUser) {
        dbRepository.save(newUser);
        users.put(newUser.getUsername(), newUser);
    }

    public void updateUser(User requestedUser, String username, String password, String about_me, String profilePictureURL) {
        requestedUser.setUsername(username);
        requestedUser.setPassword(password);
        requestedUser.setAbout_me(about_me);
        requestedUser.setProfilePictureURL(profilePictureURL);

        dbRepository.save(requestedUser);
        users.put(requestedUser.getUsername(), requestedUser);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    private void getAllUsers() {
        List<User> userList = dbRepository.findAll();

        for(User user: userList) {
            users.put(user.getUsername(), user);
        }
    }
}
