package com.tss.library.service;

import com.tss.library.model.BorrowRecord;
import com.tss.library.model.Library;
import com.tss.library.model.Members;
import com.tss.library.utils.InputTaker;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class MembersService {
    private static Library library = null;

    public MembersService(Library library) {
        MembersService.library = library;
    }

    public void addMember() {
        int id = genrateUniqueMemberId();
        String name = InputTaker.readName("Enter member name: ");
        String email;
        do {
            email = InputTaker.readEmail("Enter member email: ");
        } while (!checkUniqueEmailId(email));
        Members member = new Members(id, name, email);
        library.getMemberStore().put(id, member);
        System.out.println("Member created successfully");
    }

    public void getBooksBorrowedByMembers() {
        int memberId = InputTaker.readInt("Enter valid member id: ", 0);
        Members member = getMemberById(memberId);
        if (member == null) {
            System.out.println("No member found!");
            return;
        }
        List<BorrowRecord> borrowedBooks = library.getBorrowedBookList();
        if (borrowedBooks == null) {
            System.out.println("No borrow books found in list");
            return;
        }
        System.out.printf("%-10s %-15s %-30s %-20s %-20s%n",
                "BookID", "ISBN", "Title", "Borrowed Date", "Return Date");
        System.out.println("-------------------------------------------------------------------------------------------");

        borrowedBooks.forEach(record -> {
            if (record.getMember().getId() == memberId) {
                System.out.printf("%-10d %-15d %-30s %-20s %-20s%n",
                        record.getBook().getId(),
                        record.getBook().getISBN(),
                        record.getBook().getTitle(),
                        record.getBorrowedDate(),
                        record.getReturnDate() == null ? "Not Returned" : record.getReturnDate()
                );
            }
        });

    }

    public static Members getMemberById(int id) {
        Map<Integer, Members> members = library.getMemberStore();

        for (Map.Entry<Integer, Members> e : members.entrySet()) {
            if (e.getValue().getId() == id) {
                return e.getValue();
            }
        }
        return null;
    }

    public void displayAllMembers() {
        Map<Integer, Members> members = library.getMemberStore();

        if (members.isEmpty()) {
            System.out.println("No members found in the library.");
            return;
        }

        System.out.printf("%-8s %-20s %-25s%n", "MemberID", "Name", "Email");
        System.out.println("--------------------------------------------------------");

        for (Members member : members.values()) {
            System.out.printf("%-8d %-20s %-25s%n",
                    member.getId(),
                    member.getName(),
                    member.getEmail()
            );
        }
    }

    public static boolean checkUniqueEmailId(String email) {
        Map<Integer, Members> members = library.getMemberStore();

        for (Map.Entry<Integer, Members> e : members.entrySet()) {
            if (e.getValue().getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public static int genrateUniqueMemberId() {
        Random random = new Random();
        int id;
        do {
            id = random.nextInt(1000, 9999) + 1;
        } while (getMemberById(id) != null);
        return id;
    }
}
