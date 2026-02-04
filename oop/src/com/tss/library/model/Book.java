package com.tss.library.model;

public class Book {
    protected final int ISBN;
    protected String title;
    protected String author;
    protected String category;

    public Book(int ISBN, String title, String author, String category) {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
