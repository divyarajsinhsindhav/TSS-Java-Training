package com.tss.library;

import com.tss.library.service.LibraryController;

public class Main {
    public static void main(String[] args) {
        LibraryController libraryController = new LibraryController();
        libraryController.start();
    }
}
