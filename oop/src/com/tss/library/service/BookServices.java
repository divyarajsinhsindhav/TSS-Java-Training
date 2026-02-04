package com.tss.library.service;

import com.tss.library.model.Book;
import com.tss.library.model.BookCopy;
import com.tss.library.utils.InputTaker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BookServices {

    private static Library library = null;

    public BookServices(Library library) {
        BookServices.library = library;
    }

    public void addBook() {
        int ISBN = InputTaker.readInt("Enter ISBN: ");

        if (getBookByISBN(ISBN) != null) {
            BookCopy book = getBookByISBN(ISBN);
            library.getBookStore().put(genrateUniqueBookId(), book);
        }

        String title = InputTaker.readString("Enter title of Book: ");
        String author = InputTaker.readName("Enter author name of Book: ");
        String category = InputTaker.readString("Enter category: ");
        int bookId = genrateUniqueBookId();
        Book newBook = new Book(ISBN, title, author, category);
        BookCopy bookCopy = new BookCopy(bookId, newBook);
        library.getBookStore().put(bookId, bookCopy);
    }

    public static void displaySingleBook(int id) {
        BookCopy book = getBookByISBN(id);
        if (book == null) {
            System.out.println("Book not found with your given Id");
        }
        System.out.println("Id: " + book.getId() + "\n" +
                "ISBN: " + book.getISBN() + "\n" +
                "Title: " + book.getTitle() + "\n" +
                "Category: " + book.getAuthor() + "\n" +
                "Borrowed: " + book.isBorrowed() + "\n");
    }

    public void displayBook() {
        Map<Integer, BookCopy> books = library.getBookStore();

        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.printf("%-8s %-15s %-30s %-20s %-15s %-10s%n",
                "CopyID", "ISBN", "Title", "Author", "Category", "Borrowed");
        System.out.println("------------------------------------------------------------------------------------------");

        for (BookCopy copy : books.values()) {
            System.out.printf("%-8d %-15s %-30s %-20s %-15s %-10s%n",
                    copy.getId(),
                    copy.getISBN(),
                    copy.getTitle(),
                    copy.getAuthor(),
                    copy.getCategory(),
                    copy.isBorrowed() ? "Yes" : "No"
            );
        }
    }

    public static BookCopy getBookById(int id) {
        Map<Integer, BookCopy> books = new HashMap<>(library.getBookStore());
        for(Map.Entry<Integer, BookCopy> e : books.entrySet()) {
            BookCopy book = e.getValue();
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public int genrateUniqueBookId() {
        Random random = new Random();
        int bookId;
        do {
            bookId = random.nextInt(1000, 9999) + 1;
        } while (getBookById(bookId) == null);
        return bookId;
    }

    public static BookCopy getBookByISBN(int ISBN) {
        Map<Integer, BookCopy> books = new HashMap<>(library.getBookStore());
        for(Map.Entry<Integer, BookCopy> e : books.entrySet()) {
            BookCopy book = e.getValue();
            if (book.getISBN() == ISBN) {
                return book;
            }
        }
        return null;
    }
}
