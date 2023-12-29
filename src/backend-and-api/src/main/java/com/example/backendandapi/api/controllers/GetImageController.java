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
    public ResponseEntity<Resource> getImage(@RequestParam String imageName) {
        BufferedImage image;
        ByteArrayResource imageData = null;
        ByteArrayOutputStream imageTempData = new ByteArrayOutputStream();

        String username = Miscellaneous.getImageNameInfo(imageName, false);
        String imageFormat = Miscellaneous.getImageNameInfo(imageName, true);
        ResponseStatus status = verifyRequest(username);

        if(status != ResponseStatus.OPERATION_SUCCESSFUL) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        try {
            image = imageDbService.getImage(username, imageFormat);
            ImageIO.write(image, imageFormat, imageTempData);
            imageData = new ByteArrayResource(imageTempData.toByteArray());
        } catch(IOException error) {
            System.out.println("Error in sending image response: " + error);
        }

        return ResponseEntity.status(HttpStatus.OK).contentLength(imageData.contentLength()).body(imageData);
    }

    private ResponseStatus verifyRequest(String username) {
        if(userDbService.getUser(username) == null) {
            return ResponseStatus.USERNAME_NOT_FOUND;
        }

        return ResponseStatus.OPERATION_SUCCESSFUL;
    }
}
