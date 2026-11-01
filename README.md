### Library Management System (Java)

## What This Project Does

This project is a **Library Management System** developed using Java. It allows users to manage books in a library by performing operations such as adding, viewing, searching, issuing, returning, and deleting books.
The system also uses **file handling**, so all data is saved in a file (`books.txt`) and remains available even after restarting the program.

## Problem It Solves

Managing library records manually is inefficient and prone to errors. This system provides a simple and efficient way to handle book records digitally.

## How to Set Up

### 1. Requirements

* Java (JDK 8 or above)
* Any IDE (VS Code / IntelliJ) OR Terminal

### 2. Download / Clone the Repository

```
git clone <your-repo-link>
cd Library-Management-System-Java
```

### 3. Compile the Program

```
javac LibrarySystem.java
```

### 4. Run the Program

```
java LibrarySystem
```

## How to Use

After running the program, a menu will appear:

```
--- Library Menu ---
1. Add Book
2. View Books
3. Search Book
4. Issue Book
5. Return Book
6. Delete Book
0. Exit
```

### Steps:

* Enter `1` to add a new book
* Enter `2` to view all books
* Enter `3` to search a book by ID
* Enter `4` to issue a book
* Enter `5` to return a book
* Enter `6` to delete a book
* Enter `0` to exit

## Data Storage

* All book data is stored in a file named `books.txt`
* Data is saved automatically after every operation
* When the program starts, it loads data from the file

## Technologies Used

* Java
* OOP (Classes and Objects)
* ArrayList
* File Handling (BufferedReader & BufferedWriter)

## Project Files

```
LibraryManagementSystem/
│── LibrarySystem.java
│── books.txt
```

## What I Learned

* Implemented Object-Oriented Programming concepts
* Used file handling for persistent storage
* Built a real-world Java application
* Improved logical and problem-solving skills

## Author
Akankshya Dibyadarsinee Rout (Google @2028)
24BAI10724
B.Tech (AIML) | VIT Bhopal University
