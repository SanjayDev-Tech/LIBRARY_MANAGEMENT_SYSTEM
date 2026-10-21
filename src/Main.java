import controller.LibraryController;
import model.Library;
import view.LibraryView;

public class Main {
    public static void main(String[] args) {
       
        Library library = new Library();

       
        LibraryView view = new LibraryView();

        
        LibraryController app = new LibraryController(library, view);


        app.start();
    }
}
