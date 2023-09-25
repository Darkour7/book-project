import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            Library library = new Library();
            List<Book> list = library.uploadBooks("src/exercise.csv");

            System.out.println("Lista de libros");
            library.showBooks();
            System.out.println("__________________________");
            System.out.println("Filtrado por ciudad");
            library.filterByCountry("España").stream().forEach(System.out::println);;
            System.out.println("___________________________");
            System.out.println("Ordenar descendente");
            library.sortByNameDescendant().stream().forEach(System.out::println);;
            System.out.println("___________________________");
            System.out.println("Lista de libros diferentes");
            System.out.println(library.getDifferentBooks());
            System.out.println("___________________________");
            System.out.println("Lista de autores diferentes");
            library.showDifferentAuthors();
            System.out.println("___________________________");
            System.out.println("Busqueda Miguel de Cervantes");
            library.findByAuthor(new Author("Miguel de Cervantes", "España"));

            System.out.println("___________________________");
            System.out.println("Busqueda Dilan");
            library.findByAuthor(new Author("Dilan", "Bolivia"));

        }catch(IOException exception){
            System.err.println(exception.getMessage());
        }

    }

}