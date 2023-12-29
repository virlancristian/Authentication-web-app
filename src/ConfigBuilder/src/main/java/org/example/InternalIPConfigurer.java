package org.example;

import java.io.*;

public class InternalIPConfigurer {
    String internalIP;
    File internalIPFile;
    File frontendConfigFile;

    public InternalIPConfigurer() {
        internalIPFile = new File("internal_ip.txt");
        frontendConfigFile = new File("src/frontend/.env");
    }

    public void copyInternalIP() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(internalIPFile));

            System.out.println("Copying internal IP...");
            internalIP = reader.readLine();
        } catch(IOException error) {
            System.out.println("Error in opening the internal_ip.txt file!\n" + error);
        }
    }

    public void writeInternalIP() {
        try {
            FileWriter writer = new FileWriter(frontendConfigFile);

            System.out.println("Writing internal IP to .env ...");

            writer.write("REACT_APP_INTERNAL_IP=" + internalIP);
            writer.close();

            System.out.println("Frontend config built successfully!");
        } catch(IOException error) {
            System.out.println("Error in writing to .env!\n" + error);
        }
    }
}
