package com.firmant.randomImage.Controller;


import com.firmant.randomImage.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// handle the get request
@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    // Return a random image
    @GetMapping(value = "/random",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getRandomImage(@RequestParam("type") String type) {
        if (type.equals("pc") || type.equals("mp")) {
            try {
                File image = new File(imageService.getRandomImage(type).getUrl());
                FileInputStream fis = new FileInputStream(image);
                byte[] bytes = new byte[fis.available()];
                fis.read(bytes);
                return bytes;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

}
