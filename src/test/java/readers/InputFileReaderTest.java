package readers;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputFileReaderTest {
    String fileName;

    @Test
    void readFileTest() {
        InputFileReader.path = "D:" + File.separator + "work" + File.separator + "repository" + File.separator
                + "test-project" + File.separator + "src" + File.separator + "test" + File.separator
                + "resources" + File.separator;
        fileName = "input.txt";
        String[] input = InputFileReader.readFile(fileName);
        assertEquals(6, input.length);
        assertEquals("card-1234", input[5]);
    }
}