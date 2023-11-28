package com.example.backendandapi.api.controllers;

import com.example.backendandapi.models.dbentities.UserDbEntity;
import com.example.backendandapi.models.responses.UserInfo;
import com.example.backendandapi.services.userdb.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAccountController {
    UserDbService userDbService;

    @Autowired
    public GetAccountController(UserDbService userDbService) {
        this.userDbService = userDbService;
    }

    @GetMapping("/api/account")
    public ResponseEntity<UserInfo> getAccount(@RequestParam String username) {
        UserDbEntity requestedUser = userDbService.getUser(username);

        if(requestedUser == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                new UserInfo(requestedUser.getUsername(), requestedUser.getProfilePictureURL(), requestedUser.getAbout_me()),
                HttpStatus.OK
        );
    }
}
