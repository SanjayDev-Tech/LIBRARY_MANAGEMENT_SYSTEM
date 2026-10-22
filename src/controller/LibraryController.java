package controller;

import model.Book;
import model.Library;
import view.LibraryView;

public class LibraryController {
    private Library library;
    private LibraryView view;

    public LibraryController(Library library, LibraryView view) {
        this.library = library;
        this.view = view;
        preloadSampleData();
    }

    private void preloadSampleData() {
        library.addBook(new Book("978-0131103627", "The C Programming Language", "Dennis Ritchie", "PROGRAMMING"));
        library.addBook(new Book("978-0735211292", "Atomic Habits", "James Clear", "SELF-HELP"));
        library.addBook(new Book("978-0132350884", "Clean Code", "Robert C. Martin", "PROGRAMMING"));
    }

    public void start() {
        while (true) {
            view.displayMenu();
            int choice = view.getUserChoice();

            switch (choice) {
                case 1:
                    handleAddBook();
                    break;

                case 2:
                    library.displayAllBooks();
                    break;

                case 3:
                    handleSearch();
                    break;

                case 4:
                    handleDeleteBook();
                    break;

                case 5:
                    handleAssignBook();
                    break;

                case 6:
                    handleReturnBook();
                    break;

                case 7:
                    view.showMessage("Goodbye!");
                    view.close();
                    return;

                default:
                    view.showMessage("Invalid choice! Select 1-7.");
                    break;
            }
        }
    }

    private void handleAddBook() {
        String isbn = view.getUserInput("Enter ISBN: ");
        String title = view.getUserInput("Enter Title: ");
        String author = view.getUserInput("Enter Author: ");
        String tag = view.getUserInput("Enter Tag: ");

        boolean success = library.addBook(new Book(isbn, title, author, tag));
        if (success) {
            view.showMessage(" Book added successfully!");
        } else {
            view.showMessage("\n Failed to add book: Duplicate ISBN is not allowed.");
        }
    }

    private void handleDeleteBook() {
        String isbn = view.getUserInput("Enter ISBN to delete: ");
        library.deleteBook(isbn);
    }

    private void handleAssignBook() {
        String isbn = view.getUserInput("Enter ISBN of book to assign: ");
        int status = library.assignBook(isbn);

         if (status == 1) {
        view.showMessage("Book assigned successfully!");
    } else if (status == 2) {
        view.showMessage(" Book is already assigned to someone else!");
    } else {
        view.showMessage("Book not found with this ISBN!");
    }

    }

    private void handleReturnBook() {
        String isbn = view.getUserInput("Enter ISBN of book to return: ");
        library.unassignBook(isbn);
    }

    private void handleSearch() {
        view.displaySearchMenu();
        int type = view.getUserChoice();

        String q = view.getUserInput("Enter Query: ");

        switch (type) {
            case 1:
                library.searchByTitle(q);
                break;

            case 2:
                library.searchByAuthor(q);
                break;

            case 3:
                library.searchByTag(q);
                break;

            default:
                view.showMessage(" Invalid search type!");
                break;
        }
    }
}
