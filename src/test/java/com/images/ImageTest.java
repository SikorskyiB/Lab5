package com.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImageTest {
    Image img;

    @BeforeEach
    public void setUp() {
        img = new Image();
    }

    @Test
    public void testNoFilter() {
        assertEquals("Default", img.getFilter());
    }

    @Test
    public void testParisFilter() {
        img = new ParisFilter(img);
        assertEquals("Default, Paris", img.getFilter());
    }

    @Test
    public void testBlurFilter() {
        img = new BlurFilter(img);
        assertEquals("Default, Blur", img.getFilter());
    }

    @Test
    public void testMultipleFilters() {
        img = new ParisFilter(img);
        img = new BlurFilter(img);
        assertEquals("Default, Paris, Blur", img.getFilter());
    }

    @Test
    public void testDisplayFilterOutput() {
        img = new ParisFilter(img);
        img = new BlurFilter(img);

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        img.displayFilter();
        assertEquals("Filters: Default, Paris, Blur\r\n", out.toString());

        System.setOut(System.out);
    }
}
