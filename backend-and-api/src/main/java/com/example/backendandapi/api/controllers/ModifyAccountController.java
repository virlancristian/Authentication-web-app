package com.example.backendandapi.api.controllers;

import com.example.backendandapi.api.common.RequestVerifierConstants;
import com.example.backendandapi.api.common.ResponseStatus;
import com.example.backendandapi.models.dbentities.UserDbEntity;
import com.example.backendandapi.models.requests.ModifyAccountRequest;
import com.example.backendandapi.services.userdb.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModifyAccountController {
    UserDbService userDbService;

    @Autowired
    public ModifyAccountController(UserDbService userDbService) {
        this.userDbService = userDbService;
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping("/api/account/edit")
    public ResponseEntity<ResponseStatus> modifyAccount(@RequestBody ModifyAccountRequest account) {
        ResponseStatus status = verifyRequest(account);

        if(!status.equals(ResponseStatus.OPERATION_SUCCESSFUL)) {
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }

        userDbService.modifyUser(account);

        return new ResponseEntity<>(ResponseStatus.OPERATION_SUCCESSFUL, HttpStatus.OK);
    }

    private ResponseStatus verifyRequest(ModifyAccountRequest account) {
        UserDbEntity requestedAccount = userDbService.getUser(account.getOldUsername());

        if(requestedAccount == null) {
            return ResponseStatus.USERNAME_NOT_FOUND;
        }

        if(!verifyField(account.getNewUsername(), RequestVerifierConstants.USERNAME_REGEX, true)) {
            return ResponseStatus.INVALID_USERNAME;
        }

        if(!verifyField(account.getOldPassword(), requestedAccount.getPassword(), false)) {
            return ResponseStatus.INCORRECT_PASSWORD;
        }

        if(!verifyField(account.getNewPassword(), RequestVerifierConstants.PASSWORD_REGEX, true)) {
            return ResponseStatus.INVALID_PASSWORD;
        }

        if(!verifyField(account.getNewPassword(), account.getNewPasswordConfirm(), false)) {
            return ResponseStatus.PASSWORDS_NOT_MATCHING;
        }

        return ResponseStatus.OPERATION_SUCCESSFUL;
    }

    private boolean verifyField(String field, String matchingString, boolean isRegex) {
        if(field == null) {
            return true;
        }

        return isRegex ? field.matches(matchingString) : field.equals(matchingString);
    }
}
