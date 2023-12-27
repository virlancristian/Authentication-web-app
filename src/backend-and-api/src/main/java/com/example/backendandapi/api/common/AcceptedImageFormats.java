package com.example.backendandapi.api.common;

import java.util.ArrayList;
import java.util.List;

public class AcceptedImageFormats {
    private static final String[] imageFormatsArray = {"jpg", "jpeg", "png"};
    public static final List<String> IMAGE_FORMATS = new ArrayList<>(List.of(imageFormatsArray));
}
