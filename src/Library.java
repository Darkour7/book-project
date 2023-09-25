import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> bookList;
    public Library() {
        this.bookList = new ArrayList<>();
    }
    public List<Book> uploadBooks(String path) throws IOException {
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
        book.setType(element.get("tipo"));
        book.setAntiquityYears(Integer.parseInt(element.get("antiguedad")));
        book.setEditorial(element.get("editorial"));
        book.setSoldUnits(element.get("ejemplaresVendidos"));
        book.setAuthor(new Author(element.get("autor"), element.get("paisAutor")));
        return book;
    }

    public void showBooks() {
        bookList.stream().forEach(System.out::println);
    }

    public List<Book> filterByCountry(String country){
        return bookList
                .stream()
                .filter(book->book.getAuthor().getCountryOfOrigin().equals(country))
                .collect(Collectors.toList());
    }


    public List<Book> sortByNameDescendant(){
        return bookList
                .stream()
                .sorted((book1, book2)->book2.getBookName().compareTo(book1.getBookName()))
                .collect(Collectors.toList());
    }

    public Long getDifferentBooks(){
        HashSet<Book> differentBooks = new HashSet<>(bookList);
        return differentBooks
                .stream()
                .count();
    }
    public int getDifferentBooksHashSet(){
        return new HashSet<>(bookList).size();
    }
    public void showDifferentAuthors(){
        bookList
                .stream()
                .map(Book::getAuthor)
                .distinct()
                .forEach(System.out::println);
    }

    public void findByAuthor(Author author){
        boolean exist = bookList
                .stream()
                .anyMatch(book -> book.getAuthor().equals(author));
        if(exist)
            System.out.println("AUTOR POPULAR");
        else
            System.out.println("AUTOR NO ENCONTRADO");
    }
}
