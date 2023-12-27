package com.example.backendandapi.services.imagedb;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ImageDbService implements ImageDbRepository {
    public ImageDbService() {
        File dbDirectory = new File("images");

        if(!dbDirectory.exists()) {
            dbDirectory.mkdir();
        }
    }

    @Override
    public void saveImage(MultipartFile image, String imageName, String imageFormat) {
        try {
            byte[] imageData = image.getBytes();
            File imageFile = new File("images/" + imageName + "." + imageFormat);
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(imageFile));

            if(imageFile != null) {
                deleteImage(imageName, imageFormat);
            }

            outputStream.write(imageData);
            outputStream.close();
        } catch(IOException error) {
            System.out.println("Error in getting image data: " + error);
        }
    }

    @Override
    public BufferedImage getImage(String imageName, String imageFormat) {
        File imageFile = new File("images/" + imageName + "." + imageFormat);
        BufferedImage image = null;

        try {
            image = ImageIO.read(imageFile);
        } catch(IOException error) {
            System.out.println("Error in reading the image: " + error);
        }

        return image;
    }

    @Override
    public void deleteImage(String imageName, String imageFormat) {
        try {
            Files.delete(Paths.get("images/" + imageName + "." + imageFormat));
        } catch(IOException error) {
            System.out.println("Error in deleting the image: " + error);
        }
    }
}
