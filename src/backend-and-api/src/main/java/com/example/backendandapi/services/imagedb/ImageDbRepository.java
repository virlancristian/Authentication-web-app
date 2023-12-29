package com.example.backendandapi.services.imagedb;

import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;

public interface ImageDbRepository {
    void saveImage(MultipartFile image, String imageName, String imageFormat);
    BufferedImage getImage(String imageName, String imageFormat);
    void deleteImage(String imageName, String imageFormat);
}
