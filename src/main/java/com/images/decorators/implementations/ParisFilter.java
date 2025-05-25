package com.images.decorators.implementations;

import com.images.Image;
import com.images.decorators.ImageDecorator;

public class ParisFilter extends ImageDecorator {
    public ParisFilter(Image image) {
        super(image, "Paris");
    }
}
