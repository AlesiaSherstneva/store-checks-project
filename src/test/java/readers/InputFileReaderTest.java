package readers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputFileReaderTest {
    String path;

    @Test
    void readFileTest() {
        path = "D:\\work\\repository\\test-project\\src\\test\\resources\\input.txt";
        String[] input = InputFileReader.readFile(path);
        assertEquals(6, input.length);
        assertEquals("card-1234", input[5]);
    }
}