import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataReader {

    public static void ReadFile(String path) throws IOException {
        File file = new File(path);
        Scanner buffer = new Scanner(file);

        while(buffer.hasNextLine()){
            String line = buffer.nextLine();
            System.out.println(line);
            String [] content = line.split(",");
        }

    }
}
