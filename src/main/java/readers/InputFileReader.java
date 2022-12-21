package readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class InputFileReader {
    static StringBuilder result;
    static String path = "D:" + File.separator + "work" + File.separator + "repository" + File.separator
            + "test-project" + File.separator + "src" + File.separator + "main" + File.separator
            + "resources" + File.separator;

    public static String[] readFile(String fileName) {
        result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path + fileName))) {
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