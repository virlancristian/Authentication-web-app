package com.example.backendandapi.models.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "username")
    String username;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "profilePictureURL")
    String profilePictureURL;
    @Column(name = "about_me")
    String about_me;

    public User() {}

    public User(int id, String username, String email, String password, String profilePictureURL, String about_me) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.about_me = about_me;
        this.password = password;
        this.profilePictureURL = profilePictureURL;
    }

    public User(String username, String email, String password, String profilePictureURL, String about_me) {
        this.username = username;
        this.email = email;
        this.about_me = about_me;
        this.password = password;
        this.profilePictureURL = profilePictureURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username != null) {
            this.username = username;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout_me() {
        return about_me;
    }

    public void setAbout_me(String about_me) {
        if (about_me != null) {
            this.about_me = about_me;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null) {
            this.password = password;
        }
    }

    public String getProfilePictureURL() {
        return profilePictureURL;
    }

    public void setProfilePictureURL(String profilePictureURL) {
        if (profilePictureURL != null) {
            this.profilePictureURL = profilePictureURL;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", about_me='" + about_me + '\'' +
                ", password='" + password + '\'' +
                ", profilePictureURL='" + profilePictureURL + '\'' +
                '}';
    }
}
