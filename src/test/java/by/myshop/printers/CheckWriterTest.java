package by.myshop.printers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.io.FileUtils;

import static org.junit.jupiter.api.Assertions.*;

class CheckWriterTest {
    String testCheck;
    File file;

    @BeforeEach
    void setUp() {
        Map<Integer, Integer> shopping = new LinkedHashMap<>();
        shopping.put(5, 3);
        shopping.put(8, 1);
        testCheck = new CheckPrinter().printCheck(shopping, true);
        CheckWriter.path = "D:" + File.separator + "work" + File.separator + "repository"
                + File.separator + "test-project" + File.separator + "src" + File.separator
                + "test" + File.separator + "resources" + File.separator + "archive" + File.separator;
        file = new File(CheckWriter.path);
    }

    @Test
    void writeCheckToArchiveTest() {
        CheckWriter.writeCheckToArchive(testCheck);
        assertTrue(file.isDirectory());
        assertEquals(1, Objects.requireNonNull(file.listFiles()).length);
    }

    @AfterEach
    void tearDown() {
        try {
            FileUtils.cleanDirectory(file);
            @SuppressWarnings("unused")
            boolean delete = file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}