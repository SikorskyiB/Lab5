package com.images.decorators.implementations;

import com.images.Image;
import com.images.decorators.ImageDecorator;

public class BlurFilter extends ImageDecorator {
    public BlurFilter (Image image) {
        super(image, "Blur");
    }
}
