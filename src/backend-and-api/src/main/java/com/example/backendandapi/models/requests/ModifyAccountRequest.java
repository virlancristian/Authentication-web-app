package com.example.backendandapi.models.requests;

public class ModifyAccountRequest {
    String oldUsername;
    String newUsername;
    String profilePictureURL;
    String about_me;
    String oldPassword;
    String newPassword;
    String newPasswordConfirm;

    public ModifyAccountRequest() {}

    public ModifyAccountRequest(String oldUsername, String newUsername, String profilePictureURL, String about_me, String oldPassword, String newPassword, String newPasswordConfirm) {
        this.oldUsername = oldUsername;
        this.newUsername = newUsername;
        this.profilePictureURL = profilePictureURL;
        this.about_me = about_me;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.newPasswordConfirm = newPasswordConfirm;
    }

    public String getOldUsername() {
        return oldUsername;
    }

    public void setOldUsername(String oldUsername) {
        this.oldUsername = oldUsername;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordConfirm() {
        return newPasswordConfirm;
    }

    public void setNewPasswordConfirm(String newPasswordConfirm) {
        this.newPasswordConfirm = newPasswordConfirm;
    }

    @Override
    public String toString() {
        return "ModifyAccountRequest{" +
                "username='" + oldUsername + '\'' +
                ", profilePictureURL='" + profilePictureURL + '\'' +
                ", about_me='" + about_me + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", newPasswordConfirm='" + newPasswordConfirm + '\'' +
                '}';
    }
}
