package printers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import org.apache.commons.io.FileUtils;

import static org.junit.jupiter.api.Assertions.*;

public class CheckWriterTest {
    private final Map<Integer, Integer> shopping;
    private File file;

    private final Random random;

    public CheckWriterTest() throws IOException {
        shopping = new LinkedHashMap<>();
        random = new Random();

        CheckWriter.path = String.format("%s%s%s%s%s%s%s%s%s%s", new File("").getCanonicalPath(),
                File.separator, "src", File.separator, "test", File.separator, "resources", File.separator,
                "archive", File.separator);
    }

    @Test
    void writeCheckToArchiveTest() {
        shopping.put(random.nextInt(12) + 1, random.nextInt(20) + 1);
        shopping.put(random.nextInt(12) + 1, random.nextInt(30) + 1);
        String testCheck = new CheckPrinter().printCheck(shopping, random.nextBoolean());

        CheckWriter.writeCheckToArchive(testCheck);

        file = new File(CheckWriter.path);
        assertTrue(file.isDirectory());
        assertEquals(1, Objects.requireNonNull(file.listFiles()).length);
    }

    @AfterEach
    void tearDown() {
        try {
            FileUtils.cleanDirectory(file);
            @SuppressWarnings("unused") boolean delete = file.delete();
        } catch (IOException exception) {
            fail("Test directory should be deleted!");
        }
    }
}