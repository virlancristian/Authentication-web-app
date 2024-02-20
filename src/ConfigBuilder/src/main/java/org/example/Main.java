package org.example;

public class Main {
    public static void main(String[] args) {
        if(!args[0].equals("frontend") && !args[0].equals("backend")) {
            throw new IllegalArgumentException("Invalid build phase!");
        }

        new App(args[0].equals("frontend") ? 1 : 2).run();
    }
}