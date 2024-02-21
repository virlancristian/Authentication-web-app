package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileIO {
    private File inputFile;

    public TextFileIO(String fileName) {
        inputFile = new File(fileName);
    }

    public String readSingleLine() {
        String readLine = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            readLine = reader.readLine();
        } catch(IOException error) {
            System.out.println("Error in TextFileIO::readSingleLine() - couldn't create BufferedReader");
        }

        return readLine;
    }

    public List<String> readAllLines() {
        List<String> readLines = new ArrayList<>();
        String buffer;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            while((buffer = reader.readLine()) != null) {
                readLines.add(buffer);
            }
        } catch(IOException error) {
            System.out.println("Error in TextFileIO::readAllLines() - unable to read from file " + inputFile.getName() + ": " + error);
        }

        return readLines;
    }

    public void writeSingleLine(String input) {
        try {
            FileWriter writer = new FileWriter(inputFile);

            writer.write(input);
            writer.close();
        } catch(IOException error) {
            System.out.println("Error in TextFileIO::writeSingleLine() - unable to write to " + inputFile.getName() + ": " + error);
        }
    }

    public void writeAllLines(List<String> lines) {
        try {
            FileWriter writer = new FileWriter(inputFile);

            for(String line:lines) {
                writer.write(line + '\n');
            }

            writer.close();
        } catch(IOException error) {
            System.out.println("Error in TextFileIO::writeAllLines() - unable to write to " + inputFile.getName() + ": " + error);
        }
    }
}
