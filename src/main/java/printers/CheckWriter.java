package printers;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class CheckWriter {
    static String path = "D:" + File.separator + "work" + File.separator + "repository"
            + File.separator + "test-project" + File.separator + "archive" + File.separator;

    public static void writeCheckToArchive(String check) {
        @SuppressWarnings({"RedundantExplicitVariableType", "unused"})
        boolean mkdir = new File(path).mkdir();

        try (FileWriter fileWriter = new FileWriter(path + "check" +
                new Date().toString().substring(3, 19)
                        .replaceAll(" ", "-")
                        .replaceAll(":", "-")
                + ".txt")) {
            fileWriter.write(check);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}