package org.example;

import java.util.Scanner;

public class InputReader {
    private Scanner reader;
    private String providedIp;
    private String providedDbUsername;
    private String providedDbPassword;

    public InputReader() {
        reader = new Scanner(System.in);
        providedIp = null;
        providedDbUsername = null;
        providedDbPassword = null;
    }

    public void readInput() {
        readProvidedIp();
        readDbCredentials();
    }

    private void readProvidedIp() {
        boolean isLocal = false;
        char inputLetter = '\0';

        System.out.println("Would you like to run the app locally?");

        while(!(inputLetter == 'y') && !(inputLetter == 'n')) {
            inputLetter = reader.next().toLowerCase().charAt(0);

            if(!(inputLetter == 'y') && !(inputLetter == 'n')) {
                System.out.println("Invalid input! Please provide one of the following inputs: Y(es) / N(o)");
            } else {
                isLocal = inputLetter == 'y';
            }
        }

        if(!isLocal) {
            System.out.println("Please provide the external IP / domain URL");
            providedIp = reader.next();
        } else {
            providedIp = "http://"
                        + new TextFileIO("local_ip.txt").readSingleLine()
                        + ":8080";
        }
    }

    private void readDbCredentials() {
        boolean correctCredentials = false;
        System.out.println("Please provide the database credentials");

        while(!correctCredentials) {
            System.out.print("Username:");
            providedDbUsername = reader.next();

            System.out.print("Password:");
            providedDbPassword = reader.next();

            System.out.println("Are the provided credentials correct? (Y / N)");
            correctCredentials = reader.next().toLowerCase().charAt(0) == 'y';
        }
    }

    public String getProvidedIp() {
        return providedIp;
    }

    public String getProvidedDbUsername() {
        return providedDbUsername;
    }

    public String getProvidedDbPassword() {
        return providedDbPassword;
    }
}
