package com.tss.library.model;

import java.time.LocalDate;
import java.util.Date;

public class BorrowRecord {
    private int id;
    private final int bookId;
    private final int ISBN;
    private final String bookTitle;
    private final int memberId;
    private final String memberName;
    private final LocalDate borrowedDate;
    private LocalDate returnDate;

    public BorrowRecord(int bookId, int ISBN, String bookTitle, int memberId, String memberName) {
        this.bookId = bookId;
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.memberId = memberId;
        this.memberName = memberName;
        this.borrowedDate = LocalDate.now();
        this.returnDate = null;
    }

    public int getId() {
        return id;
    }

    public int getISBN() {
        return ISBN;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
