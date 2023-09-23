import java.util.Date;

public class Book {

    private String bookName;
    private int releaseDate;
    private Author author;
    private String editorial;
    //private String type;
    //private String soldUnits;
    //private int pageQuantity;
    //private int antiquityYears;

    public Book(){}

    public Book(String bookName, int releaseDate, Author author, String editorial){
        this.bookName = bookName;
        this.releaseDate = releaseDate;
        this.author = author;
        this.editorial = editorial;
    }

    public Book(String bookName, int releaseDate, String authorName, String authorOriginCountry, String editorial){
        this.bookName = bookName;
        this.releaseDate = releaseDate;
        this.author = new Author(authorName, authorOriginCountry);
        this.editorial = editorial;
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

    @Override
    public String toString(){
        return "\"\"%s\"\" - (%s) \n Written by: %s \n Published by: %s"
                .formatted(this.getBookName(), this.getReleaseDate() ,this.getAuthor().toString(), this.getEditorial());
    }

}
