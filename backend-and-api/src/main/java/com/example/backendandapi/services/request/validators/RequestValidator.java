package com.example.backendandapi.services.request.validators;

import com.example.backendandapi.models.request.bodies.BaseRequestBody;
import org.springframework.stereotype.Service;

@Service
public abstract class RequestValidator<T extends BaseRequestBody>{
    abstract boolean isValidRequest(T requestBody);
}
