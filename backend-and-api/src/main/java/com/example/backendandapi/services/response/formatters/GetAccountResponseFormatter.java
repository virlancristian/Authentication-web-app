package com.example.backendandapi.services.response.formatters;

import com.example.backendandapi.models.response.bodies.GetAccountResponse;
import com.example.backendandapi.models.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetAccountResponseFormatter extends ResponseFormatter<GetAccountResponse, User> {
    @Override
    public ResponseEntity<GetAccountResponse> formatResponse(User user, int statusCode) {
        return ResponseEntity.status(statusCode).body(new GetAccountResponse(user.getUsername(),
                                                                        user.getAbout_me(),
                                                                        user.getProfilePictureURL()));
    }
}
