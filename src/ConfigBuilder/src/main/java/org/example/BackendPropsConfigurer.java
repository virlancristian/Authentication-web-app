package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BackendPropsConfigurer {
    String dbUsername;
    String dbPassword;
    List<String> properties;
    File propertiesFile;
    File dbCredentialsFile;

    public BackendPropsConfigurer() {
        this.propertiesFile = new File("src\\backend-and-api\\src\\main\\resources\\application.properties");
        this.dbCredentialsFile = new File("database_credentials.txt");
        this.properties = new ArrayList<>();
    }

    public void readBackendProperties() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(propertiesFile));
            String line;

            System.out.println("Reading application.properties...");

            while((line = reader.readLine()) != null) {
                properties.add(line);
            }
        } catch(IOException error) {
            System.out.println("Error in reading application.properties!" + error);
        }
    }

    public void readDbCredentials() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dbCredentialsFile));

            System.out.println("Reading database_credentials.txt");

            dbUsername = reader.readLine();
            dbPassword = reader.readLine();

            if(dbUsername == null) {
                throw new RuntimeException("Error in reading database_credentials.txt: please provide the username!");
            }

            if(dbPassword == null) {
                throw new RuntimeException("Error in reading database_credentials.txt: please provide the password!");
            }
            System.out.println(dbUsername + " " + dbPassword);
        } catch(IOException error) {
            System.out.println("Error in reading database_credentials.txt!\n" + error);
        }
    }

    public void overwriteBackendProperties() {
        try {
            FileWriter writer = new FileWriter(propertiesFile);

            System.out.println(dbUsername + " " + dbPassword);
            System.out.println("Overwriting application.properties");

            for(String property:properties) {
                if(property.equals("spring.datasource.username=")) {
                    writer.write(property + dbUsername + '\n');
                } else if(property.equals("spring.datasource.password=")) {
                    writer.write(property + dbPassword + '\n');
                } else {
                    writer.write(property + '\n');
                }
            }

            writer.close();
            System.out.println("Backend config built successfully!");
        } catch(IOException error) {
            System.out.println("Error in overwriting application.properties!\n" + error);
        }
    }
}
