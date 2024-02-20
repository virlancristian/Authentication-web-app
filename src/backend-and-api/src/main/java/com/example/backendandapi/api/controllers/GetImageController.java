package com.example.backendandapi.api.controllers;

import com.example.backendandapi.api.common.Miscellaneous;
import com.example.backendandapi.api.common.ResponseStatus;
import com.example.backendandapi.services.imagedb.ImageDbService;
import com.example.backendandapi.services.userdb.UserDbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class GetImageController {
    ImageDbService imageDbService;
    UserDbService userDbService;

    @Autowired
    public GetImageController(ImageDbService imageDbService, UserDbService userDbService) {
        this.imageDbService = imageDbService;
        this.userDbService = userDbService;
    }

    @CrossOrigin
    @GetMapping(value = "/api/account/pfp/get", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
    public ResponseEntity<Resource> getImage(@RequestParam(value = "imageName") String fullImageName) {
        BufferedImage image;
        ByteArrayResource imageData = null;
        ByteArrayOutputStream imageTempData = new ByteArrayOutputStream();

        String imageName = Miscellaneous.splitImageName(fullImageName, false);
        String imageFormat = Miscellaneous.splitImageName(fullImageName, true);
        Long userId = (long) imageName.charAt(5) - '0';

        if(verifyRequest(userId) != ResponseStatus.OPERATION_SUCCESSFUL) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        try {
            image = imageDbService.getImage(imageName, imageFormat);
            ImageIO.write(image, imageFormat, imageTempData);
            imageData = new ByteArrayResource(imageTempData.toByteArray());
        } catch(IOException error) {
            System.out.println("Error in sending image response: " + error);
        }

        return ResponseEntity.status(HttpStatus.OK).contentLength(imageData.contentLength()).body(imageData);
    }

    private ResponseStatus verifyRequest(Long userId) {
        return userDbService.findUserById(userId) != null ? ResponseStatus.OPERATION_SUCCESSFUL : ResponseStatus.USERNAME_NOT_FOUND;
    }
}
