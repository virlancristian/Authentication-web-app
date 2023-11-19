package com.example.backendandapi.services.response.formatters;

import com.example.backendandapi.models.response.bodies.BaseResponseBody;
import com.example.backendandapi.models.user.User;
import org.springframework.http.ResponseEntity;

public abstract class ResponseFormatter<T extends BaseResponseBody, S extends Object> {
    abstract ResponseEntity<T> formatResponse(S obj, int statusCode);
}
