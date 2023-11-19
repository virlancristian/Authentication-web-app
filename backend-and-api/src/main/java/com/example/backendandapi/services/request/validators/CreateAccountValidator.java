package com.example.backendandapi.services.request.validators;

import com.example.backendandapi.common.ValidatorConstants;
import com.example.backendandapi.models.request.bodies.CreateAccountReqBody;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountValidator extends RequestValidator<CreateAccountReqBody> {
    @Override
    public boolean isValidRequest(CreateAccountReqBody requestBody) {
        String username = requestBody.getUsername();
        String email = requestBody.getEmail();
        String password = requestBody.getPassword();

        if(!username.matches(ValidatorConstants.USERNAME_REGEX)) {
            return false;
        }

        if(!email.matches(ValidatorConstants.EMAIL_REGEX)) {
            return false;
        }

        if(!password.matches(ValidatorConstants.PASSWORD_REGEX)) {
            return false;
        }

        return true;
    }
}
