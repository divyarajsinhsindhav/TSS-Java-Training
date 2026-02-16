package com.tss.structural.proxy;

import com.tss.structural.proxy.RealGalleryImage;

public class ImageProxy implements GalleryImage {

    private String path;
    private RealGalleryImage realImage;

    public ImageProxy(String path) {
        this.path = path;
    }

    @Override
    public void displayThumbnail() {
        System.out.println("Quickly showing cached thumbnail for: " + path);
    }

    @Override
    public void displayFullImage() {
        if (realImage == null) {
            realImage = new RealGalleryImage(path);
        }
        realImage.displayFullImage();
    }
}
