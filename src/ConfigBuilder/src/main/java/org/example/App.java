package org.example;


import java.util.ArrayList;
import java.util.List;

public class App {
    private int buildPhase;      //1 - frontend configuration, 2 - backend configuration
    private static final String APPLICATION_PROPERTIES_PATH = "/src/backend-and-api/src/main/resources/application.properties";

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
            List<String> applicationProperties = new TextFileIO(APPLICATION_PROPERTIES_PATH).readAllLines();
            List<String> overwrittenProperties = null;

            inputReader.readInput();

            dbCredentials.add(inputReader.getProvidedDbUsername());
            dbCredentials.add(inputReader.getProvidedDbPassword());
            overwrittenProperties = overwriteBackendProperties(dbCredentials, applicationProperties, false);

            new TextFileIO("src/frontend/.env").writeSingleLine("REACT_APP_PROVIDED_IP=" + inputReader.getProvidedIp());
            new TextFileIO(APPLICATION_PROPERTIES_PATH).writeAllLines(overwrittenProperties);
            new TextFileIO("database_credentials.txt").writeAllLines(dbCredentials);
        } else {
            List<String> dbCredentials = new TextFileIO("database_credentials.txt").readAllLines();
            List<String> applicationProperties = new TextFileIO(APPLICATION_PROPERTIES_PATH).readAllLines();
            List<String> cleanProperties = overwriteBackendProperties(dbCredentials, applicationProperties, true);

            new TextFileIO(APPLICATION_PROPERTIES_PATH).writeAllLines(cleanProperties);
        }
    }

    private List<String> overwriteBackendProperties(List<String> dbCredentials, List<String> applicationProperties, boolean clean) {
        List<String> overwrittenProps = new ArrayList<>();

        for(String property:applicationProperties) {
            if(property.contains("spring.datasource.username=")) {
                overwrittenProps.add(clean ? "spring.datasource.username=" : (property + dbCredentials.get(0)));
            } else if(property.contains("spring.datasource.password=")) {
                overwrittenProps.add(clean ? "spring.datasource.password" : (property + dbCredentials.get(1)));
            }
        }

        return overwrittenProps;
    }
}
