package com.example.backendandapi.api.common;

public class Miscellaneous {
    public static String splitImageName(String imageName, boolean extensionRequired) {
        if(imageName == null) {
            return null;
        }

        String[] splitImageName = imageName.split("\\.");

        return extensionRequired ?  splitImageName[splitImageName.length - 1] : splitImageName[0];
    }
}
