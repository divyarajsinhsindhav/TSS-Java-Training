package com.tss.library.service;

import com.tss.library.model.Book;
import com.tss.library.model.BookCopy;
import com.tss.library.model.BorrowRecord;
import com.tss.library.model.Members;

import java.util.*;

public class Library {
    private static Map<Integer, BookCopy> bookStore = new LinkedHashMap<>();
    private static Map<Integer, Members> memberStore = new HashMap<>();
    private static List<BorrowRecord> borrowedBookList = new ArrayList<>();

    public Map<Integer, BookCopy> getBookStore() {
        return bookStore;
    }

    public Map<Integer, Members> getMemberStore() {
        return memberStore;
    }

    public List<BorrowRecord> getBorrowedBookList() {
        return borrowedBookList;
    }
}
