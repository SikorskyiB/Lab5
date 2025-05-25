package com.teslalab;

import com.images.Image;
import com.images.decorators.ImageDecorator;
import com.images.decorators.implementations.*;
import com.processors.ImageProcessor;
import com.processors.implementations.*;

public class Main {
    public static void main(String[] args) {

        ImageProcessor processor1 = new ObjectDetector();
        ImageProcessor processor2 = new FaceAnalyzer();
        ImageProcessor processor3 = new ThreatsAssessor();

        processor1.link(processor2, processor3);

        System.out.println("\n\tСтворюємо img1");
        Image img1 = new Image();
        img1.displayFilter();
        processor1.process(img1);


        System.out.println("\n\tНакладаємо на img1 фільтр 'Paris'");
        img1 = new ParisFilter(img1);
        img1.displayFilter();
        processor1.process(img1);

        System.out.println("\n\tСтворюємо img2 і одразу накладаємо фільтр 'Blur'");
        Image img2 = new BlurFilter(new Image());
        img2.displayFilter();
        processor1.process(img2);

        System.out.println("\n\tНакладаємо на img 1 фільтр 'Blur'");
        img1 = new BlurFilter(img1);
        img1.displayFilter();
        processor1.process(img1);


    }
}