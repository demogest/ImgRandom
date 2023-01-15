package com.firmant.randomImage.service;


import com.firmant.randomImage.Entity.Image;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ImageService {

    @Value("${images.directory:images}")
    private String imgDir;
    // Get all images in resources/img
    public Image[] getAllImages(String type) {
        try{
            UrlResource resource = new UrlResource("file:" + imgDir + "/img" + type);
            File[] files = resource.getFile().listFiles();
            Image[] images = new Image[files.length];
            for (int i = 0; i < files.length; i++) {
                images[i] = new Image(files[i].getName(), files[i].getAbsolutePath());
            }
            return images;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get a random image
    public Image getRandomImage(String type) {
        Image[] images = getAllImages(type);
        int random = (int) (Math.random() * images.length);
        return images[random];
    }

}
