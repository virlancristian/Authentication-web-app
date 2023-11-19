package com.example.backendandapi.services.request.validators;

import com.example.backendandapi.common.ValidatorConstants;
import com.example.backendandapi.models.request.bodies.GetAccountReqBody;
import org.springframework.stereotype.Service;

@Service
public class GetAccountValidator extends RequestValidator<GetAccountReqBody> {
    @Override
    public boolean isValidRequest(GetAccountReqBody reqBody) {
        return reqBody.getUsername().matches(ValidatorConstants.USERNAME_REGEX);
    }
}
