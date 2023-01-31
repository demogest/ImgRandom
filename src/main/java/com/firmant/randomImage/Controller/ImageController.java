package com.firmant.randomImage.Controller;


import com.firmant.randomImage.Entity.Image;
import com.firmant.randomImage.Service.ImageService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

// handle the get request
@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    // Return a random image
    @GetMapping(value = "/random",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getRandomImage(@RequestParam("type") String type, HttpServletRequest request) throws IOException {
        // log the type and request ip
        Logger logger = Logger.getLogger(ImageController.class.getName());
        // log with JSON format
        logger.info("{\"type\":\"" + type + "\",\"ip\":\"" + request.getRemoteAddr() + "\"}");
        if (type.equals("pc") || type.equals("mp") || type.equals("all")) {
            try {
                Image image = imageService.getRandomImage(type);
                logger.info("{\"name\":\"" + image.getName() + "\",\"url\":\"" + image.getUrl() + "\"}");
                if (image.getUrl() == null) {
                    return null;
                }
                FileInputStream fis = new FileInputStream(image.getUrl());
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
