import java.util.Objects;

public class Author {

    private String name;
    private String countryOfOrigin;

    public Author (String name, String countryOfOrigin) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
    }

    public Author (){
    }

    public String getName() {
        return name;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.getName() + this.getCountryOfOrigin());
    }

    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (!(o instanceof Author)){
            return false;
        }

        Author a = (Author) o;

        return (this.getName().compareTo(a.getName()) == 0) &&
                (this.getCountryOfOrigin().compareTo(a.getCountryOfOrigin()) == 0);
    }
}
