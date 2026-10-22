package view;

import java.util.Scanner;

public class LibraryView {
    private Scanner scanner;

    public LibraryView() {
        this.scanner = new Scanner(System.in);
    }

  
    public
     void displayMenu() {
        System.out.println("\n--- LIBRARY SYSTEM MENU ---");
        System.out.println("1. Add Book | 2. Display All | 3. Search | 4. Delete | 5. Assign Book | 6. Return Book | 7. Exit");
        System.out.print("Choice: ");
    }

 
    public int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }


    public String getUserInput(String promptMessage) {
        System.out.print(promptMessage);
        return scanner.nextLine().trim();
    }

  
    public void displaySearchMenu() {
        System.out.println("\n1. Title | 2. Author | 3. Tag");
        System.out.print("Search Type: ");
    }


    public void showMessage(String message) {
        System.out.println(message);
    }


    public void close() {
        scanner.close();
    }
}
