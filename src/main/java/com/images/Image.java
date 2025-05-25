package com.images;

public class Image {
    private String filter = "Default";

    public String getFilter() {
        return this.filter;
    }

    public void displayFilter() {
        System.out.println("Filters: " + this.getFilter());
    }
}
