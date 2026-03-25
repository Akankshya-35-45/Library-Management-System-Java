package LibraryManagementSystem;

import java.io.*;
import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author, boolean isIssued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
    }
}

public class LibrarySystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "books.txt";

    public static void main(String[] args) {
        loadFromFile(); // load data at start

        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: searchBook(); break;
                case 4: issueBook(); break;
                case 5: returnBook(); break;
                case 6: deleteBook(); break;
            }

        } while (choice != 0);
    }

    // ================= FUNCTIONS =================

    static void addBook() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author, false));
        saveToFile();

        System.out.println("Book added!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        for (Book b : books) {
            System.out.println("ID: " + b.id + " | Title: " + b.title + " | Author: " + b.author + " | Issued: " + b.isIssued);
        }
    }

    static void searchBook() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                System.out.println("Found: " + b.title + " by " + b.author);
                return;
            }
        }
        System.out.println("Not found!");
    }

    static void issueBook() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && !b.isIssued) {
                b.isIssued = true;
                saveToFile();
                System.out.println("Book issued!");
                return;
            }
        }
        System.out.println("Not available!");
    }

    static void returnBook() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id && b.isIssued) {
                b.isIssued = false;
                saveToFile();
                System.out.println("Book returned!");
                return;
            }
        }
        System.out.println("Invalid!");
    }

    static void deleteBook() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        books.removeIf(b -> b.id == id);
        saveToFile();

        System.out.println("Book deleted!");
    }

    // ================= FILE HANDLING =================

    static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book b : books) {
                bw.write(b.id + "," + b.title + "," + b.author + "," + b.isIssued);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file!");
        }
    }

    static void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                boolean isIssued = Boolean.parseBoolean(data[3]);

                books.add(new Book(id, title, author, isIssued));
            }
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }
}
