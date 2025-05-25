package com.processors.implementations;

import com.images.Image;
import com.processors.ImageProcessor;

public class FaceAnalyzer extends ImageProcessor {

    @Override
    public void process(Image image) {
        if (image.getFilter().contains("Blur")) {
            System.out.println("Через наявність фільтру 'Blur' аналіз облич здійснити неможливо");
        }
        else {
            System.out.println("Аналіз облич...");
        }

        nextProcess(image);
    }
}
