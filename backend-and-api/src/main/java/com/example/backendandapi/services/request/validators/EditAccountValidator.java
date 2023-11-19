package com.example.backendandapi.services.request.validators;

import com.example.backendandapi.common.ValidatorConstants;
import com.example.backendandapi.models.request.bodies.CreateAccountReqBody;
import com.example.backendandapi.models.request.bodies.EditAccountReqBody;
import org.springframework.stereotype.Service;

@Service
public class EditAccountValidator extends RequestValidator<EditAccountReqBody>{
    @Override
    public boolean isValidRequest(EditAccountReqBody requestBody) {
        String username = requestBody.getUsername();
        String password = requestBody.getPassword();
        String newPassword = requestBody.getNewPassword();

        if(!new CreateAccountValidator().isValidRequest(new CreateAccountReqBody(username, "temp@temp.com", password, password))) {
            return false;
        }

        if(!newPassword.matches(ValidatorConstants.PASSWORD_REGEX)) {
            return false;
        }

        return true;
    }
}
