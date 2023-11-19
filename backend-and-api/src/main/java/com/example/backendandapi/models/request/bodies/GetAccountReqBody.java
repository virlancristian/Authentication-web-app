package com.example.backendandapi.models.request.bodies;

import com.example.backendandapi.models.request.bodies.BaseRequestBody;

public class GetAccountReqBody extends BaseRequestBody {
    String username;

    public GetAccountReqBody() {}

    public GetAccountReqBody(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "GetAccountReqBody{" +
                "username='" + username + '\'' +
                '}';
    }
}
