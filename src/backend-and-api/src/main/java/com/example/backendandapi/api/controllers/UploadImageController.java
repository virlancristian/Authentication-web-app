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
                                              @RequestParam(value = "username") String username) {
        String imageFormat = Miscellaneous.splitImageName(image.getOriginalFilename(), true);
        Long userId = userDbService.findIdByUsername(username);

        if(verifyRequest(image, userId, imageFormat) != ResponseStatus.OPERATION_SUCCESSFUL) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        imageDbService.saveImage(image, "user_" + userId.toString(), imageFormat);

        return ResponseEntity.status(HttpStatus.OK).body("user_" + userId.toString() + "." + imageFormat);
    }

    private ResponseStatus verifyRequest(MultipartFile image, Long userId, String imageFormat) {
        if(image == null) {
            return ResponseStatus.NULL_IMAGE;
        }

        if(!AcceptedImageFormats.IMAGE_FORMATS.contains(imageFormat)) {
            return ResponseStatus.UNSUPPORTED_IMAGE_FORMAT;
        }

        if(userDbService.findUserById(userId) == null) {
            return ResponseStatus.USERNAME_NOT_FOUND;
        }

        return ResponseStatus.OPERATION_SUCCESSFUL;
    }
}
