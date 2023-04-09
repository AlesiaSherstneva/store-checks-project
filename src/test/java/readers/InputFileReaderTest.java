package readers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputFileReaderTest {
    @Test
    void readFileTest() {
        InputFileReader.path = InputFileReader.path.replaceAll("main", "test");

        String[] input = InputFileReader.readFile("input.txt");

        assertEquals(6, input.length);
        assertEquals("card-1234", input[5]);
    }
}