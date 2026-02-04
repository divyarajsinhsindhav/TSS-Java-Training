package com.tss.library.model;

import java.util.*;

public class Library {
    private static Map<Integer, BookCopy> bookStore = new LinkedHashMap<>();
    private static Map<Integer, Members> memberStore = new HashMap<>();
    private static List<BorrowRecord> borrowedBookList = new ArrayList<>();
    private static Set<String> category = new HashSet<>();

    public Map<Integer, BookCopy> getBookStore() {
        return bookStore;
    }

    public Map<Integer, Members> getMemberStore() {
        return memberStore;
    }

    public List<BorrowRecord> getBorrowedBookList() {
        return borrowedBookList;
    }

    public Set<String> getCategory() {
        return category;
    }
}
