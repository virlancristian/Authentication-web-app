package com.example.backendandapi.api.common;

public class RequestVerifierConstants {
    public static String USERNAME_REGEX = "^(?=.*[A-Za-z])[^\s]+$";
    public static String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
    public static String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\\\"\\\\\\\\|,.<>\\/?]).{6,}$";
}
