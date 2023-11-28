package com.example.backendandapi.api.controllers;

import com.example.backendandapi.api.common.RequestVerifierConstants;
import com.example.backendandapi.api.common.ResponseStatus;
import com.example.backendandapi.models.requests.CreateAccountRequest;
import com.example.backendandapi.models.dbentities.UserDbEntity;
import com.example.backendandapi.services.userdb.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateAccountController {
    UserDbService userDbService;

    @Autowired
    public CreateAccountController(UserDbService userDbService) {
        this.userDbService = userDbService;
    }

    @PutMapping(value = "/api/account/create")
    public ResponseEntity<ResponseStatus> createAccount(@RequestBody CreateAccountRequest requestedAccount) {
        ResponseStatus status = verifyRequest(requestedAccount);

        if(!status.equals(ResponseStatus.OPERATION_SUCCESSFUL)) {
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }

        userDbService.addUser(new UserDbEntity(requestedAccount.getUsername(), requestedAccount.getEmail(), requestedAccount.getPassword(), null, null));

        return new ResponseEntity<>(ResponseStatus.OPERATION_SUCCESSFUL, HttpStatus.OK);
    }

    private ResponseStatus verifyRequest(CreateAccountRequest requestedAccount) {
        String username = requestedAccount.getUsername();
        String email = requestedAccount.getEmail();
        String password = requestedAccount.getPassword();

        if(username == null || !username.matches(RequestVerifierConstants.USERNAME_REGEX)) {
            return ResponseStatus.INVALID_USERNAME;
        }

        if(userDbService.getUser(username) != null) {
            return ResponseStatus.ACCOUNTS_EXISTS;
        }

        if(email == null || !email.matches(RequestVerifierConstants.EMAIL_REGEX)) {
            return ResponseStatus.INVALID_EMAIL;
        }

        if(password == null || !password.matches(RequestVerifierConstants.PASSWORD_REGEX)) {
            return ResponseStatus.INVALID_PASSWORD;
        }

        if(!password.equals(requestedAccount.getConfirmPassword())) {
            return ResponseStatus.PASSWORDS_NOT_MATCHING;
        }

        return ResponseStatus.OPERATION_SUCCESSFUL;
    }
}
