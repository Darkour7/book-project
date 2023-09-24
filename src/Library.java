import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Library {
    private ArrayList<Book> bookList;
    public Library() {
        this.bookList = new ArrayList<>();
    }
    public ArrayList<Book> uploadBooks(String path) throws IOException {
        ArrayList<HashMap<String, String>> listFromFile = DataReader.readDataFromFile(path);
        for (HashMap<String, String> element: listFromFile) {
            bookList.add(convertToBook(element));
        }
        return bookList;
    }
    private Book convertToBook(HashMap<String, String> element){
        Book book = new Book();
        book.setBookName(element.get("\uFEFFlibro"));
        book.setReleaseDate(Integer.parseInt(element.get("fechaPublicacion")));
        book.setPageQuantity(Integer.parseInt(element.get("cantidadPaginas")));
        book.setType(getBookType(element.get("tipo")));
        book.setAntiquityYears(Integer.parseInt(element.get("antiguedad")));
        book.setEditorial(element.get("editorial"));
        book.setSoldUnits(element.get("ejemplaresVendidos"));
        book.setAuthor(new Author(element.get("autor"), element.get("paisAutor")));
        return book;
    }
    private BookType getBookType(String type){
        BookType bookType = BookType.OTHER;
        switch (type){
            case "Novela de Caballerías":
                bookType = BookType.CHIVALRIC_NOVEL;
                break;
            case "Fantasía Épica":
                bookType = BookType.EPIC_FANTASY;
                break;
            case "Fantasía":
                bookType = BookType.FANTASY;
                break;
            default:
                bookType = BookType.OTHER;
        }
        return bookType;
    }
}
