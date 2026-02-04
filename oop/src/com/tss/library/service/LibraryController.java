package com.tss.library.service;

import com.tss.library.model.Library;
import com.tss.library.utils.InputTaker;

public class LibraryController {
    Library library = new Library();
    BookServices bookServices = new BookServices(library);
    MembersService membersService = new MembersService(library);
    BorrowAndReturnService borrowAndReturnService = new BorrowAndReturnService(library);

    public void start() {
        while (true) {
            displayMenu();
            int userChoice = InputTaker.readInt("Enter valid choice: ", 1, 9);
            menu(userChoice);
        }
    }

    private void displayMenu() {
        System.out.println("""
                \n
                1. Add Book
                2. Add Member
                3. Borrow Book
                4. Return Book
                5. View all Book
                6. View all members
                7. View borrowed books by member
                8. View member by borrowed book
                9. History of Borrow and Return
                10. Exit
                """);
    }

    private void menu(int userChoice) {
        switch (userChoice) {
            case 1:
                bookServices.addBook();
                break;
            case 2:
                membersService.addMember();
                break;
            case 3:
                borrowAndReturnService.borrowBook();
                break;
            case 4:
                borrowAndReturnService.returnBook();
                break;
            case 5:
                bookServices.displayBook();
                break;
            case 6:
                membersService.displayAllMembers();
                break;
            case 7:
                membersService.getBooksBorrowedByMembers();
                break;
            case 8:
                borrowAndReturnService.getMemberByBorrowedBook();
                break;
            case 9:
                borrowAndReturnService.displayHistoryOfBorrowedAndReturn();
                break;
            case 10:
                return;
            default:
                System.out.println("Please enter valid choice");
        }
    }
}
