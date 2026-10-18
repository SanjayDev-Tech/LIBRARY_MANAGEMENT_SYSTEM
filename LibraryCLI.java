import java.util.Scanner;

public class LibraryCLI {
    private Library library;
    private Scanner scanner;

    public LibraryCLI() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
        preloadSampleData();
    }

    private void preloadSampleData() {
        library.addBook(new Book("978-0131103627", "The C Programming Language", "Dennis Ritchie", "PROGRAMMING"));
        library.addBook(new Book("978-0735211292", "Atomic Habits", "James Clear", "SELF-HELP"));
        library.addBook(new Book("978-0132350884", "Clean Code", "Robert C. Martin", "PROGRAMMING"));
    }

    public void start() {
       while (true) {
    displayMenu();
    int choice = getUserChoice();

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
            System.out.println("Goodbye!");
            scanner.close();
            return;

        default:
            System.out.println("Invalid choice! Select 1-5.");
            break;
    }
}
    }

    private void displayMenu() {
        System.out.println("\n--- LIBRARY SYSTEM MENU ---");
        System.out.println("1. Add Book | 2. Display All | 3. Search | 4. Delete | 5. Exit");
        System.out.print("Choice: ");
    }

    private int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    private void handleAddBook() {
        System.out.print("Enter ISBN: "); String isbn = scanner.nextLine().trim();
        System.out.print("Enter Title: "); String title = scanner.nextLine().trim();
        System.out.print("Enter Author: "); String author = scanner.nextLine().trim();
        System.out.print("Enter Tag: "); String tag = scanner.nextLine().trim();
        library.addBook(new Book(isbn, title, author, tag));
    }

    private void handleDeleteBook() {
        System.out.print("Enter ISBN to delete: ");
        library.deleteBook(scanner.nextLine().trim());
    }

    private void handleSearch() {
    System.out.println("1. Title | 2. Author | 3. Tag");
    System.out.print("Search Type: ");
    int type = getUserChoice();
    
    System.out.print("Enter Query: ");
    String q = scanner.nextLine().trim();

   
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
            System.out.println("Invalid search type!");
            break;
    }
}
}