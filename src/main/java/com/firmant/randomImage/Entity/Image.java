package com.firmant.randomImage.Entity;

import lombok.Data;

// Image class
@Data
public class Image {
    private String name;
    private String url;

    public Image(String name, String url) {
        this.name = name;
        this.url = url;
    }

}
