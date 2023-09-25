import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataReader {

    private static final String SEPARATOR = ",";
    public static void ReadFile(String path) throws IOException {
        File file = new File(path);
        Scanner buffer = new Scanner(file);

        while(buffer.hasNextLine()){
            String line = buffer.nextLine();
            System.out.println(line);
            String [] content = line.split(SEPARATOR);
        }

    }


    public static ArrayList<HashMap<String, String>> readDataFromFile(String filePath) throws IOException{
        ArrayList<HashMap<String, String>> registryMapList = new ArrayList<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                String[] columnTitle = scanner.nextLine().split(SEPARATOR);
                while (scanner.hasNextLine()) {
                    HashMap<String, String> registryMap = new HashMap<>();
                    String[] columnValue = scanner.nextLine().split(SEPARATOR);
                    for (int i = 0; i < columnTitle.length; i++) {
                        registryMap.put(columnTitle[i].trim(), columnValue[i].trim());
                    }
                    registryMapList.add(registryMap);
                }
            }
        } catch (FileNotFoundException e) {
            registryMapList = new ArrayList<>();
        }
        return registryMapList;
    }
}
