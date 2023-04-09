package printers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class CheckWriter {
    static String path;

    static {
        try {
            File dir = new File("archive");
            path = String.format("%s%s", dir.getCanonicalPath(), File.separator);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void writeCheckToArchive(String check) {
        @SuppressWarnings("unused") boolean mkdir = new File(path).mkdir();

        try (FileWriter fileWriter = new FileWriter(String.format("%s%s%s%s", path, "check",
                new Date().toString().substring(3, 19)
                        .replaceAll(" ", "-")
                        .replaceAll(":", "-"), ".txt"))) {
            fileWriter.write(check);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}