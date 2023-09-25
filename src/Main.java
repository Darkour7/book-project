import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try{
            Library library = new Library();
            ArrayList<Book> list = library.uploadBooks("src/exercise.csv");

            System.out.println("hola");
        }catch(IOException exception){
            System.err.println(exception.getMessage());
        }

    }

}