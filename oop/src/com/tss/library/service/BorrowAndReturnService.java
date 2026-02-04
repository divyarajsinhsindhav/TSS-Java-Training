package com.tss.library.service;

import com.tss.library.model.Book;
import com.tss.library.model.BookCopy;
import com.tss.library.model.BorrowRecord;
import com.tss.library.model.Members;
import com.tss.library.utils.InputTaker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowAndReturnService {

    private static Library library = null;

    public BorrowAndReturnService(Library library) {
        BorrowAndReturnService.library = library;
    }

    public void borrowBook() {
        int memberId = InputTaker.readInt("Enter valid member id: ");
        Members member = MembersService.getMemberById(memberId);
        if (member == null) {
            System.out.println("No member found");
            return;
        }
        int bookId = InputTaker.readInt("Enter valid book id: ", 0);
        BookCopy book = BookServices.getBookById(bookId);
        if (book == null) {
            System.out.println("Book with given id is not found");
            return;
        }
        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
            return;
        }
        book.borrow();
        System.out.println("Thank you for borrow the book." + "\n" +
                "----------------------------------------------------");
        BookServices.displaySingleBook(bookId);
        BorrowRecord borrowRecord = new BorrowRecord(book.getId(), book.getISBN(), book.getTitle(), member.getId(), member.getName());
        library.getBorrowedBookList().add(borrowRecord);
    }

    public void returnBook() {
        int bookId = InputTaker.readInt("Enter valid book id: ", 0);
        BookCopy book = BookServices.getBookById(bookId);
        if (book == null) {
            System.out.println("Book with given id is not found");
            return;
        }
        if(!book.isBorrowed()) {
            System.out.println("Book is possible to return because it's not borrowed still");
        }
        book.returnBook();
        System.out.println("Thank you for return the book");
        List<BorrowRecord> borrowRecordList = library.getBorrowedBookList();
        borrowRecordList.forEach(record -> {
            if (record.getBookId() == bookId && record.getReturnDate() != null) {
                record.setReturnDate(LocalDate.now());
            }
        });
    }

    public void getMemberByBorrowedBook(int memberId) {
        List<BorrowRecord> borrowRecordList = new ArrayList<>();
        borrowRecordList.forEach(record -> {
            if (record.getBookId() == memberId && record.getBorrowedDate() != null) {
                System.out.println();
            }
        });
    }
}
