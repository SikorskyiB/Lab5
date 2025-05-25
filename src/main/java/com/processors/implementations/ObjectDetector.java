package com.processors.implementations;

import com.images.Image;
import com.processors.ImageProcessor;

public class ObjectDetector extends ImageProcessor {

    @Override
    public void process(Image image) {
        if (image.getFilter().contains("Paris")) {
            System.out.println("Через наявність фільтру 'Paris' знаходження предметів здійснити неможливо");
        }
        else {
            System.out.println("Знаходження предметів...");
        }

        nextProcess(image);
    }
}
