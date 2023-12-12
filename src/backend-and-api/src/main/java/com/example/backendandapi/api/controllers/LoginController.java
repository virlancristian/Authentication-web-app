package com.example.backendandapi.api.controllers;

import com.example.backendandapi.api.common.ResponseStatus;
import com.example.backendandapi.models.requests.LoginRequest;
import com.example.backendandapi.models.dbentities.UserDbEntity;
import com.example.backendandapi.services.userdb.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    UserDbService userDbService;
    @Value("${internal.ip}")
    private static final String INTERNAL_IP = "";
    private static final String FRONTEND_SERVER_ADDRESS = "http://" + INTERNAL_IP + ":3000";

    @Autowired
    public LoginController(UserDbService userDbService) {
        this.userDbService = userDbService;
    }

    @CrossOrigin(origins = {"http://localhost:3000", FRONTEND_SERVER_ADDRESS})
    @PostMapping("/api/account/login")
    public ResponseEntity<ResponseStatus> login(@RequestBody LoginRequest account) {
        ResponseStatus status = verifyRequest(account);

        if(!status.equals(ResponseStatus.OPERATION_SUCCESSFUL)) {
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(ResponseStatus.OPERATION_SUCCESSFUL, HttpStatus.OK);
    }

    private ResponseStatus verifyRequest(LoginRequest account) {
        UserDbEntity requestedAccount = userDbService.getUser(account.getUsername());

        if(requestedAccount == null) {
            return ResponseStatus.USERNAME_NOT_FOUND;
        }

        if(account.getPassword() == null || !account.getPassword().equals(requestedAccount.getPassword())) {
            return ResponseStatus.INCORRECT_PASSWORD;
        }

        return ResponseStatus.OPERATION_SUCCESSFUL;
    }
}
