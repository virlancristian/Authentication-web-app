package com.example.backendandapi.models.dbentities;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class UserDbEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String email;
    String password;
    String profilePictureURL;
    String about_me;

    public UserDbEntity() {}

    public UserDbEntity(String username, String email, String password, String profilePictureURL, String about_me) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePictureURL = profilePictureURL;
        this.about_me = about_me;
    }

    public UserDbEntity(Long id, String username, String email, String password, String profilePictureURL, String about_me) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePictureURL = profilePictureURL;
        this.about_me = about_me;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id != null) {
            this.id = id;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username != null) {
            this.username = username;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null) {
            this.email = email;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password != null) {
            this.password = password;
        }
    }

    public String getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        if(profilePictureURL != null) {
            this.profilePictureURL = profilePictureURL;
        }
    }

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        if(about_me != null) {
            this.about_me = about_me;
        }
    }

    @Override
    public String toString() {
        return "UserDbEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profilePictureURL='" + profilePictureURL + '\'' +
                ", about_me='" + about_me + '\'' +
                '}';
    }
}
