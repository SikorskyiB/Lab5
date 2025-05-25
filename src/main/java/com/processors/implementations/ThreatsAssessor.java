package com.processors.implementations;

import com.images.Image;
import com.processors.ImageProcessor;

public class ThreatsAssessor extends ImageProcessor {

    @Override
    public void process(Image image) {
        if (image.getFilter().contains("Paris") && image.getFilter().contains("Blur")) {
            System.out.println("Через наявність обох фільтрів 'Paris' і 'Blur' оцінку небезпек здійснити неможливо");
        }
        else {
            System.out.println("Оцінювання небезпек...");
        }

        nextProcess(image);
    }
}
