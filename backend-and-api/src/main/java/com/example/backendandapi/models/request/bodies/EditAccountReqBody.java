package com.example.backendandapi.models.request.bodies;

public class EditAccountReqBody extends BaseRequestBody {
    String username;
    String about_me;
    String profilePictureURL;
    String password;
    String newPassword;

    public EditAccountReqBody() {}

    public EditAccountReqBody(String username, String about_me, String profilePictureURL, String password, String newPassword) {
        this.username = username;
        this.about_me = about_me;
        this.profilePictureURL = profilePictureURL;
        this.password = password;
        this.newPassword = newPassword;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "EditAccountReqBody{" +
                "username='" + username + '\'' +
                ", about_me='" + about_me + '\'' +
                ", profilePictureURL='" + profilePictureURL + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
