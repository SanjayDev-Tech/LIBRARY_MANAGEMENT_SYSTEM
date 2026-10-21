package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public void deleteBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                books.remove(book);
                System.out.println("Deleted: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("\n--- Library Books ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchByTitle(String title) {
        System.out.println("\nSearching for title: " + title);
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
            }
        }
    }

    public void searchByAuthor(String author) {
        System.out.println("\nSearching for author: " + author);
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                System.out.println(book);
            }
        }
    }

    public void searchByTag(String tag) {
        System.out.println("\nSearching for tag: " + tag);
        for (Book book : books) {
            if (book.getTag().equalsIgnoreCase(tag)) {
                System.out.println(book);
            }
        }
    }

    public int  assignBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    return 1;
                   
                } else {
                    return 2;
                }
                
            }
        }
       return 0;
    }

    public void unassignBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Success: Book '" + book.getTitle() + "' has been returned!");
                } else {
                    System.out.println("This book was not assigned. It is already in the library!");
                }
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
    }
}
