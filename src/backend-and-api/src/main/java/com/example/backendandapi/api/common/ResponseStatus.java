package com.example.backendandapi.api.common;

public enum ResponseStatus {
    OPERATION_SUCCESSFUL("Operation completed successfully!"),
    INVALID_USERNAME("Invalid username. The username must include letters of the English alphabet and not contain spaces"),
    INVALID_EMAIL("Invalid email."),
    INVALID_PASSWORD("Invalid password. Password must contain a letter, a digit, a special character and must have a minimum length of 6 characters"),
    USERNAME_NOT_FOUND("Username not found."),
    INCORRECT_PASSWORD("Incorrect password!"),
    PASSWORDS_NOT_MATCHING("Passwords don't match."),
    ACCOUNT_EXISTS("Account already exists!"),
    NULL_IMAGE("Image is null!"),
    UNSUPPORTED_IMAGE_FORMAT("The image format is not supported!");

    private String message;

    ResponseStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
