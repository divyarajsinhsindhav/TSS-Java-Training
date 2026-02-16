package com.tss.structural.proxy;

public class RealGalleryImage implements GalleryImage {

    private String path;

    public RealGalleryImage(String path) {
        this.path = path;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading FULL image from disk: " + path);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void displayThumbnail() {
        System.out.println("Displaying thumbnail of: " + path);
    }

    @Override
    public void displayFullImage() {
        System.out.println("Displaying FULL image: " + path);
    }
}
