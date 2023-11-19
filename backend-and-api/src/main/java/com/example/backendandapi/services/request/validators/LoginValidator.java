package com.example.backendandapi.services.request.validators;

import com.example.backendandapi.models.request.bodies.LoginReqBody;
import com.example.backendandapi.models.user.User;
import com.example.backendandapi.services.database.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginValidator extends RequestValidator<LoginReqBody> {
    UserDbService userDbService;

    @Autowired
    public LoginValidator(UserDbService userDbService) {
        this.userDbService = userDbService;
    }

    @Override
    public boolean isValidRequest(LoginReqBody requestBody) {
        User requestedUser = userDbService.getUser(requestBody.getUsername());

        if(requestedUser == null) {
            return false;
        }

        return requestedUser.getPassword().equals(requestBody.getPassword());
    }
}
