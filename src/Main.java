import controller.LibraryController;
import model.Library;
import view.LibraryView;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize Model
        Library library = new Library();

        // 2. Initialize View
        LibraryView view = new LibraryView();

        // 3. Initialize Controller (Connects Model and View)
        LibraryController app = new LibraryController(library, view);

        // Start Application
        app.start();
    }
}
