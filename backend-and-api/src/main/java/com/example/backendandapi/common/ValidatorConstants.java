package com.example.backendandapi.common;

public class ValidatorConstants {
    public static String USERNAME_REGEX = "^[a-zA-Z]+$";
    public static String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
    public static String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\\\"\\\\\\\\|,.<>\\/?]).{6,}$";
}
