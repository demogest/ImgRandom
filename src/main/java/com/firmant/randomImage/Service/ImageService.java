package com.firmant.randomImage.Service;


import com.firmant.randomImage.Entity.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ImageService {

    @Value("${images.directory:images}")
    private String imgDir;

    // Get all images in resources/img
    public File[] getAllImages(String type) {
        try {
            if (!type.equals("all")) {
                UrlResource resource = new UrlResource("file:" + imgDir + "/img" + type);
                return resource.getFile().listFiles();
            } else {
                UrlResource resource_mp = new UrlResource("file:" + imgDir + "/imgmp");
                UrlResource resource_pc = new UrlResource("file:" + imgDir + "/imgpc");
                // Merge two arrays
                File[] files_mp = resource_mp.getFile().listFiles();
                File[] files_pc = resource_pc.getFile().listFiles();
                assert files_mp != null;
                assert files_pc != null;
                File[] files = new File[files_mp.length + files_pc.length];
                System.arraycopy(files_mp, 0, files, 0, files_mp.length);
                System.arraycopy(files_pc, 0, files, files_mp.length, files_pc.length);
                return files;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Get a random image
    public Image getRandomImage(String type) {
        File[] files = getAllImages(type);
        if (files.length == 0) {
            return new Image("No image", null);
        }
        // Get a random image
        int index = (int) (Math.random() * files.length);
        return new Image(files[index].getName(), files[index].getAbsolutePath());
    }

}
