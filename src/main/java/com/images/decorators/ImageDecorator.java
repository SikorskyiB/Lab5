package com.images.decorators;

import com.images.Image;

public abstract class ImageDecorator extends Image {
    private Image image;
    private String filter;

    public ImageDecorator(Image image, String filter) {
        this.image = image;
        this.filter = filter;
    }

    @Override
    public String getFilter() {
        return image.getFilter() + ", " + this.filter;
    }
}
