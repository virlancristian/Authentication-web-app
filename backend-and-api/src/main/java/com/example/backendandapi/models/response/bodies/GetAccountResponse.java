package com.example.backendandapi.models.response.bodies;

public class GetAccountResponse extends BaseResponseBody{
    String username;
    String about_me;
    String profilePictureURL;

    public GetAccountResponse() {}

    public GetAccountResponse(String username, String about_me, String profilePictureURL) {
        this.username = username;
        this.about_me = about_me;
        this.profilePictureURL = profilePictureURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }

    public String getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
    }

    @Override
    public String toString() {
        return "GetAccountResponse{" +
                "username='" + username + '\'' +
                ", about_me='" + about_me + '\'' +
                ", profilePictureURL='" + profilePictureURL + '\'' +
                '}';
    }
}
