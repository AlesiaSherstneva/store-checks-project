package readers;

import java.io.BufferedReader;
import java.io.FileReader;

public class InputFileReader {
    static StringBuilder result;

    public static String[] readFile(String path) {
        result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String inputLine = bufferedReader.readLine();
            while (inputLine != null) {
                result.append(inputLine);
                inputLine = bufferedReader.readLine();
            }
        } catch (Exception e) {
            System.out.println("File cannot be read!");
            System.exit(1);
        }
        return result.toString().split(" ");
    }
}