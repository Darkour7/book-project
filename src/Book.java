import java.util.Date;

public class Book {

    private String bookName;
    private int releaseDate;
    private Author author;
    private String editorial;
    private BookType type;
    private String soldUnits;
    private int pageQuantity;
    private int antiquityYears;

    public Book(){}

    public Book(String bookName, int releaseDate, Author author, String editorial, BookType bookType, String soldUnits,
                int pageQuantity, int antiquityYears){
        this.bookName = bookName;
        this.releaseDate = releaseDate;
        this.author = author;
        this.editorial = editorial;
        this.type = bookType;
        this.soldUnits = soldUnits;
        this.pageQuantity = pageQuantity;
        this.antiquityYears = antiquityYears;
    }

    public Book(String bookName, int releaseDate, String authorName, String authorOriginCountry, String editorial,
                BookType bookType, String soldUnits, int pageQuantity, int antiquityYears){
        this.bookName = bookName;
        this.releaseDate = releaseDate;
        this.author = new Author(authorName, authorOriginCountry);
        this.editorial = editorial;
        this.type = bookType;
        this.soldUnits = soldUnits;
        this.pageQuantity = pageQuantity;
        this.antiquityYears = antiquityYears;
    }

    public String getBookName() {
        return bookName;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public Author getAuthor() {
        return author;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public void setPageQuantity(int pageQuantity) {
        this.pageQuantity = pageQuantity;
    }

    public void setSoldUnits(String soldUnits) {
        this.soldUnits = soldUnits;
    }

    public void setAntiquityYears(int antiquityYears) {
        this.antiquityYears = antiquityYears;
    }

    @Override
    public String toString(){
        return bookName + releaseDate + author.toString() + editorial;
    }

}
