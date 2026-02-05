package com.tss.library.service;

import com.tss.library.Exception.AlreadyBorrowedBookException;
import com.tss.library.Exception.InvalidBookIdException;
import com.tss.library.Exception.InvalidMemberIdException;
import com.tss.library.model.*;
import com.tss.library.utils.InputTaker;

import java.time.LocalDate;
import java.util.List;

public class BorrowAndReturnService {

    private static Library library = null;

    public BorrowAndReturnService(Library library) {
        BorrowAndReturnService.library = library;
    }

    public void borrowBook() {
        int memberId = InputTaker.readInt("Enter valid member id: ", 0);
        Members member = MembersService.getMemberById(memberId);

        if (member == null) {
            throw new InvalidMemberIdException();
        }

        int bookId = InputTaker.readInt("Enter valid book id: ", 0);
        BookCopy book = BookServices.getBookById(bookId);

        if (book == null) {
            throw new InvalidBookIdException();
        }

        if (book.isBorrowed()) {
            throw new AlreadyBorrowedBookException();
        }

        boolean alreadyBorrowed = library.getBorrowedBookList().stream()
                .anyMatch(record ->
                        record.getMember().getId() == memberId &&
                                record.getBook().getISBN() == book.getISBN() &&
                                record.getReturnDate() == null
                );

        if (alreadyBorrowed) {
            System.out.println("You already borrowed a copy of this book (same ISBN).");
            return;
        }

        book.borrow();
        System.out.println("Thank you for borrow the book." + "\n" +
                "----------------------------------------------------");
        BookServices.displaySingleBook(bookId);

        BorrowRecord borrowRecord = new BorrowRecord(book, member);
        library.getBorrowedBookList().add(borrowRecord);
    }

    public void returnBook() {
        int bookId = InputTaker.readInt("Enter valid book id: ", 0);
        BookCopy book = BookServices.getBookById(bookId);

        if (book == null) {
            throw new InvalidBookIdException();
        }

        if(!book.isBorrowed()) {
            System.out.println("Book is possible to return because it's not borrowed still");
        }

        book.returnBook();

        System.out.println("Thank you for return the book");
        List<BorrowRecord> borrowRecordList = library.getBorrowedBookList();
        borrowRecordList.forEach(record -> {
            if (record.getBook().getId() == bookId && record.getReturnDate() == null) {
                record.setReturnDate(LocalDate.now());
            }
        });
    }

    public void getMemberByBorrowedBook() {
        if (library.getBorrowedBookList().isEmpty()) {
            System.out.println("Not any borrowed book");
            return;
        }
        int bookId = InputTaker.readInt("Enter valid book id: ");
        List<BorrowRecord> borrowRecordList = library.getBorrowedBookList();
        borrowRecordList.forEach(record -> {
            if (record.getBook().getId() == bookId && record.getReturnDate() == null) {
                Members member = record.getMember();
                System.out.println("Member Id: " + member.getId() + "\n" +
                        "Name: " + member.getName() + "\n" +
                        "Email: " + member.getEmail());
            }
        });
    }

    public void displayHistoryOfBorrowedAndReturn() {

        if (library.getBorrowedBookList().isEmpty()) {
            System.out.println("No borrow history available.");
            return;
        }

        System.out.printf("%-8s %-12s %-25s %-20s %-15s %-20s %-20s%n",
                "CopyID", "ISBN", "Title", "Member Name",
                "Member ID", "Borrowed Date", "Return Date");

        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for (BorrowRecord record : library.getBorrowedBookList()) {

            System.out.printf("%-8d %-12d %-25s %-20s %-15d %-20s %-20s%n",
                    record.getBook().getId(),
                    record.getBook().getISBN(),
                    record.getBook().getTitle(),
                    record.getMember().getName(),
                    record.getMember().getId(),
                    record.getBorrowedDate(),
                    record.getReturnDate() == null ? "Not Returned" : record.getReturnDate()
            );
        }
    }

}
