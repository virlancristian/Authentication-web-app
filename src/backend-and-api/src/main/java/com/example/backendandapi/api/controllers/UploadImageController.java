package com.example.backendandapi.api.controllers;

import com.example.backendandapi.api.common.AcceptedImageFormats;
import com.example.backendandapi.api.common.Miscellaneous;
import com.example.backendandapi.api.common.ResponseStatus;
import com.example.backendandapi.services.imagedb.ImageDbService;
import com.example.backendandapi.services.userdb.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadImageController {
    ImageDbService imageDbService;
    UserDbService userDbService;

    @Autowired
    public UploadImageController(ImageDbService imageDbService, UserDbService userDbService) {
        this.imageDbService = imageDbService;
        this.userDbService = userDbService;
    }

    @CrossOrigin
    @PostMapping("/api/account/pfp/upload")
    public ResponseEntity<String> uploadImage(@RequestBody MultipartFile image,
                                              @RequestParam String username) {
        String imageFormat = Miscellaneous.getImageNameInfo(image.getOriginalFilename(), true);
        ResponseStatus response = verifyRequest(image, username, imageFormat);
        StringBuilder imageName;

        if(response != ResponseStatus.OPERATION_SUCCESSFUL) {
            return new ResponseEntity<>(response.getMessage(), HttpStatus.BAD_REQUEST);
        }

        imageDbService.saveImage(image, username, imageFormat);
        imageName = new StringBuilder(username + "." + imageFormat);

        return ResponseEntity.status(HttpStatus.OK).body(imageName.toString());
    }

    private ResponseStatus verifyRequest(MultipartFile image, String username, String imageFormat) {
        if(image == null) {
            return ResponseStatus.NULL_IMAGE;
        }

        if(!AcceptedImageFormats.IMAGE_FORMATS.contains(imageFormat)) {
            return ResponseStatus.UNSUPPORTED_IMAGE_FORMAT;
        }

        if(userDbService.getUser(username) == null) {
            return ResponseStatus.USERNAME_NOT_FOUND;
        }

        return ResponseStatus.OPERATION_SUCCESSFUL;
    }
}
