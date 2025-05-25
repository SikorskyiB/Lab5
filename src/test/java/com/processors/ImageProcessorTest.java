package com.processors;

import com.images.Image;
import com.images.decorators.implementations.BlurFilter;
import com.images.decorators.implementations.ParisFilter;
import com.processors.implementations.FaceAnalyzer;
import com.processors.implementations.ObjectDetector;
import com.processors.implementations.ThreatsAssessor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImageProcessorTest {
    static java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
    Image img;
    ImageProcessor objectProcessor = new ObjectDetector();
    ImageProcessor faceProcessor = new FaceAnalyzer();
    ImageProcessor threatProcessor = new ThreatsAssessor();

    @BeforeAll
    static void setOut() {
        System.setOut(new java.io.PrintStream(out));
    }

    @AfterAll
    static void restoreOut() {
        System.setOut(System.out);
    }

    @BeforeEach
    public void setUp() {
        out.reset();
        img = new Image();
        objectProcessor.link(faceProcessor, threatProcessor);
    }

    @Test
    public void testNoFilters() {
        objectProcessor.process(img);

        String[] output = out.toString().split("\r\n");
        assertEquals("Знаходження предметів...", output[0]);
        assertEquals("Аналіз облич...", output[1]);
        assertEquals("Оцінювання небезпек...", output[2]);
    }

    @Test
    public void testWithBlurFilter() {
        img = new BlurFilter(img);
        objectProcessor.process(img);

        String[] output = out.toString().split("\r\n");
        assertEquals("Знаходження предметів...", output[0]);
        assertEquals("Через наявність фільтру 'Blur' аналіз облич здійснити неможливо", output[1]);
        assertEquals("Оцінювання небезпек...", output[2]);
    }

    @Test
    public void testWithParisFilter() {
        img = new ParisFilter(img);
        objectProcessor.process(img);

        String[] output = out.toString().split("\r\n");
        assertEquals("Через наявність фільтру 'Paris' знаходження предметів здійснити неможливо", output[0]);
        assertEquals("Аналіз облич...", output[1]);
        assertEquals("Оцінювання небезпек...", output[2]);
    }

    @Test
    public void testWithBothFilters() {
        img = new ParisFilter(img);
        img = new BlurFilter(img);
        objectProcessor.process(img);

        String[] output = out.toString().split("\r\n");
        assertEquals("Через наявність фільтру 'Paris' знаходження предметів здійснити неможливо", output[0]);
        assertEquals("Через наявність фільтру 'Blur' аналіз облич здійснити неможливо", output[1]);
        assertEquals("Через наявність обох фільтрів 'Paris' і 'Blur' оцінку небезпек здійснити неможливо", output[2]);
    }
}
