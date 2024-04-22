package com.pluralsight;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class NeighborhoodLibrary {
    public static void main(String[] args) {

        // Step 1 - get some books
        // Declare a class (data type) to represent a Book
        // Declare a variable to hold the books
        // Let's use an array
        // Create instances of Book objects with new
        Book book1 = new Book(1, "978-78-96067-78-01", "Tuck Everlasting", false, "Unknown");
        Book book2 = new Book(2, "858-45-95462-02-06", "Maximum Ride", false, "Unknown");
        Book book3 = new Book(3, "092-21-86019-90-16", "The Girl Who Could Fly", false, "Unknown");
        Book book4 = new Book(4, "977-00-52639-22-41", "Letters to A Young Poet", false, "Unknown");
        Book book5 = new Book(5, "272-99-73939-65-84", "The False Prince", false, "Unknown");
        Book book6 = new Book(6, "369-76-63820-98-02", "Titanic", false, "Unknown");
        Book book7 = new Book(7, "222-41-52638-02-26", "Food for Thought", false, "Unknown");
        Book book8 = new Book(8, "101-23-83736-32-91", "Kate's Recipe Book", false, "Unknown");
        Book book9 = new Book(9, "343-11-73839-65-45", "Happy Fish, Sad Fish", false, "Unknown");
        Book book10 = new Book(10, "162-22-67392-56-28", "Gifted Fruits", false, "Unknown");
        Book book11 = new Book(11, "653-09-73830-74-14", "Bud, Not Buddy", false, "Unknown");
        Book book12 = new Book(12, "235-12-35288-05-92", "Alice in Wonderland", false, "Unknown");
        Book book13 = new Book(13, "124-09-91018-32-21", "Why We Love", false, "Unknown");
        Book book14 = new Book(14, "898-65-93036-48-95", "Clean Code", false, "Unknown");
        Book book15 = new Book(15, "347-23-54649-32-32", "The Hunger Games", false, "Unknown");
        Book book16 = new Book(16, "562-30-62728-67-58", "All the Light", false, "Unknown");
        Book book17 = new Book(17, "024-62-82626-54-24", "The Dreamers", false, "Unknown");
        Book book18 = new Book(18, "654-78-63648-32-81", "Begin Again", false, "Unknown");
        Book book19 = new Book(19, "942-33-85069-16-23", "How to Dance", false, "Unknown");
        Book book20 = new Book(20, "457-09-52639-10-92", "Swing", false, "Unknown");
        Book[] books = {
                book1, book2, book3, book4, book5, book6, book7, book8, book9, book10, book11,
                book12, book13, book14, book15, book16, book17, book18, book19, book20
        };

        while (true) {

            Scanner mouse = new Scanner(System.in);
            System.out.println("Welcome to The Neighborhood Library");
            System.out.println("To begin, select an option: ");
            System.out.println("[1] Show Books Ready for Check Out");
            System.out.println("[2] Show Checked Out Books");
            System.out.println("[3] Exit");

            int optionSelection = mouse.nextInt();


            if (optionSelection == 1) {

                while (true) {
                    System.out.println("Available for Check Out: ");
                    printAvailableBooks(books);
                    System.out.println("Select [1] to Check Out a book \n " +
                            "Select [4] to return Home");
                    int newSelection = mouse.nextInt();
                    if (newSelection == 1) {

                        System.out.println("Enter the ID of the book you want to Check Out: ");
                        int checkingMeOut = mouse.nextInt();
                        System.out.println("Enter Your Full Name: ");
                        mouse.nextLine();
                        String checkOutName = mouse.nextLine();

                        // set function here
                        Book theBook = findBookById(checkingMeOut, books);
                        boolean found = false;
                        if (theBook != null) {
                            found = true;
                        }
                        if (found) {
                            System.out.println("Found 1 item");
                            theBook.setCheckedOutTo(checkOutName);
                            theBook.setCheckedOut(true);

                        } else {
                            System.out.println("Sorry, we don't have that book ID");
                        }


                        System.out.println("Book ID: " + checkingMeOut +
                                "\nChecked Out To: " + checkOutName);
                        break;


                    }
                    if (newSelection == 4) {
                        break;
                    }
                }
            } else if (optionSelection == 2) {

                while (true) {
                    System.out.println("Checked Out Books: ");
                    printUnavailableBooks(books);
                    System.out.println("Select [1] to Check In a book \n " +
                            "Select [4] to return Home");
                    int newSelection = mouse.nextInt();

                    if (newSelection == 1) {

                        System.out.println("Enter the ID of the book you want to Check In: ");

                        int checkingMeIn = mouse.nextInt();


                        // Insert set functions here
                        Book theBook = findBookById(checkingMeIn, books);
                        boolean found = false;
                        if (theBook != null) {
                            found = true;
                        }
                        if (found) {
                            System.out.println("Changing Check Out Status...");
                            theBook.setCheckedOut(false);

                        } else {
                            System.out.println("Sorry, we don't have that book ID");
                        }


                        System.out.println("Book ID: " + checkingMeIn +
                                "\nSuccessfully Checked In");
                        break;
                    } else if (newSelection == 4) {
                        break;
                    }
                }


            } else if (optionSelection == 3) {
                break;
            }
        }
    }

    static Book findBookById(int id, Book[] books) {
        for (Book b : books) {
            if (id == b.getId()) {
                return b;
            }
        }
        return null;
    }


    private static void exit() {
    }


    static void printAvailableBooks(Book[] books) {
        for (Book b : books) {
            if (!b.isCheckedOut(true)) {
                System.out.println(b.getId() + ":  " + b.getTitle() + ", ISBN: "
                        + b.getIsbn());
            }

        }
    }
    static void printUnavailableBooks(Book[] books) {
        for (Book b : books) {
            if (b.isCheckedOut(true)) {

                System.out.println(b.getId() + ":  " + b.getTitle() + ", ISBN: "
                        + b.getIsbn() + ", Checked Out To: " + b.getCheckedOutTo());
            }

        }

    }

}