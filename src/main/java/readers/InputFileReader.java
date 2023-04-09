package readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InputFileReader {
    static StringBuilder result;
    static String path;

    static {
        try {
            File dir = new File("");
            path = String.format("%s%s%s%s%s%s%s%s", dir.getCanonicalPath(), File.separator, "src",
                    File.separator, "main", File.separator, "resources", File.separator);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static String[] readFile(String fileName) {
        result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path + fileName))) {
            String inputLine = bufferedReader.readLine();
            while (inputLine != null) {
                result.append(inputLine);
                inputLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            System.out.println("File cannot be read!");
            System.exit(1);
        }
        return result.toString().split(" ");
    }
}