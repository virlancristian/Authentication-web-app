package com.example.backendandapi.models.responses;

public class UserInfo {
    String username;
    String profilePictureURL;
    String about_me;

    public UserInfo() {}

    public UserInfo(String username, String profilePictureURL, String about_me) {
        this.username = username;
        this.profilePictureURL = profilePictureURL;
        this.about_me = about_me;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        this.profilePictureURL = profilePictureURL;
    }

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", profilePictureURL='" + profilePictureURL + '\'' +
                ", about_me='" + about_me + '\'' +
                '}';
    }
}
