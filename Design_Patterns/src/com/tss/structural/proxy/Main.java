package com.tss.structural.proxy;

public class Main {

    public static void main(String[] args) {

        GalleryImage img1 = new ImageProxy("photo1.jpg");
        GalleryImage img2 = new ImageProxy("photo2.jpg");

        img1.displayThumbnail();
        img2.displayThumbnail();

        System.out.println("\nUser clicks photo1...\n");


        img1.displayFullImage();
    }
}
