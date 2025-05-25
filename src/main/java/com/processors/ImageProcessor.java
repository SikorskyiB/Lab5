package com.processors;

import com.images.Image;

public abstract class ImageProcessor {
    public ImageProcessor nextProcessor = null;

    //[Type...] -> 0 and more arguments of the type [Type]
    public void link(ImageProcessor... chain) {
        ImageProcessor current = this;

        for(ImageProcessor next: chain) {
            current.nextProcessor = next;
            current = next;
        }
    }

    public abstract void process(Image image);

    public void nextProcess(Image image) {
        if (nextProcessor != null)
            nextProcessor.process(image);
    }
}
