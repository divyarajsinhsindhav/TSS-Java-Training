package com.tss.library.model;

public class Book {
    protected final int ISBN;
    protected String title;
    protected String author;
    protected Category category;

    public Book(int ISBN, String title, String author, Category category) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public Category getCategory() {
        return this.category;
    }
}
