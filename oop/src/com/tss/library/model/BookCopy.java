package com.tss.library.model;

public class BookCopy {
    private int id;
    private boolean isBorrowed;
    private Book book;

    public BookCopy(int id, Book book) {
        this.id = id;
        this.book = book;
        this.isBorrowed = false;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBorrowed() {
        return this.isBorrowed;
    }

    public void borrow() {
        this.isBorrowed = true;
    }

    public void returnBook() {
        this.isBorrowed = false;
    }

    public int getISBN() {
        return book.getISBN();
    }

    public String getTitle() {
        return book.getTitle();
    }

    public String getAuthor() {
        return book.getAuthor();
    }

    public Category getCategory() {
        return book.getCategory();
    }

    public Book getBook() {
        return this.book;
    }
}
