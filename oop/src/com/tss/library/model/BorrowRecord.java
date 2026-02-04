package com.tss.library.model;

import java.time.LocalDate;
import java.util.Date;

public class BorrowRecord {
    private int id;
    private final BookCopy book;
    private final Members member;
    private final LocalDate borrowedDate;
    private LocalDate returnDate;

    public BorrowRecord(BookCopy book, Members member) {
        this.book = book;
        this.member = member;
        this.borrowedDate = LocalDate.now();
        this.returnDate = null;
    }

    public int getId() {
        return id;
    }

    public BookCopy getBook() {
        return book;
    }

    public Members getMember() {
        return member;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
