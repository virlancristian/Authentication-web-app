package org.example;

import org.w3c.dom.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private int buildPhase;      //1 - frontend configuration, 2 - backend configuration
    private static final String APPLICATION_PROPERTIES_PATH = "src/backend-and-api/target/classes/application.properties";

    public App(int buildPhase) {
        if(buildPhase != 1 && buildPhase != 2) {
            throw new IllegalArgumentException("Build phase not recognized!");
        }

        this.buildPhase = buildPhase;
    }

    public void run() {
        if(buildPhase == 1) {
            InputReader inputReader = new InputReader();
            List<String> dbCredentials = new ArrayList<>();

            inputReader.readInput();

            dbCredentials.add(inputReader.getProvidedDbUsername());
            dbCredentials.add(inputReader.getProvidedDbPassword());

            new TextFileIO("src/frontend/.env").writeSingleLine("REACT_APP_PROVIDED_IP=" + inputReader.getProvidedIp());
            new TextFileIO("database_credentials.txt").writeAllLines(dbCredentials);
        } else {
            List<String> dbCredentials = new TextFileIO("database_credentials.txt").readAllLines();
            List<String> applicationProperties = new TextFileIO(APPLICATION_PROPERTIES_PATH).readAllLines();

            writeBackendProperties(dbCredentials, applicationProperties);
        }
    }

    private void writeBackendProperties(List<String> dbCredentials, List<String> applicationProperties) {
        try {
            FileWriter writer = new FileWriter(APPLICATION_PROPERTIES_PATH);
            System.out.println("Overwriting application.properties");

            for(String property:applicationProperties) {
                if(property.equals("spring.datasource.username=")) {
                    writer.write("spring.datasource.username=" + dbCredentials.get(0) + '\n');
                } else if(property.equals("spring.datasource.password=")) {
                    writer.write("spring.datasource.password=" + dbCredentials.get(1) + '\n');
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
