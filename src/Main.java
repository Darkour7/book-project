import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            DataReader.ReadFile("src/exercise.csv");
        }catch(IOException exception){
            System.err.println(exception.getMessage());
        }

    }
}