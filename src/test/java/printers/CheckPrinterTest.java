package printers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CheckPrinterTest {
    Map<Integer, Integer> shopping;

    @BeforeEach
    void setUp() {
        shopping = new LinkedHashMap<>();
        shopping.put(1, 2);
        shopping.put(2, 5);
        shopping.put(3, 1);
    }

    @Test
    void checkWithDiscountCardTest() {
        CheckPrinter printer = new CheckPrinter();
        String testCheck = printer.printCheck(shopping, true);
        assertEquals("5% discount (loyalty card)", testCheck.substring(143, 169));
        assertEquals(2.20, Double.parseDouble(testCheck.substring(383, 387).replace(",", ".")));
    }

    @Test
    void checkWithoutDiscountCardTest() {
        CheckPrinter printer = new CheckPrinter();
        String testCheck = printer.printCheck(shopping, false);
        assertNotEquals("5% discount (loyalty card)", testCheck.substring(143, 169));
        assertEquals("10% discount (promotion)", testCheck.substring(175, 199));
        assertEquals(1.94, Double.parseDouble(testCheck.substring(319, 324).replace(",", ".")));
    }

    @Test
    void checkWithoutAllDiscountsTest() {
        shopping.put(2, 4);
        CheckPrinter printer = new CheckPrinter();
        String testCheck = printer.printCheck(shopping, false);
        assertNotEquals("5% discount (loyalty card)", testCheck.substring(143, 169));
        assertNotEquals("10% discount (promotion)", testCheck.substring(175, 199));
        assertEquals(0.00, Double.parseDouble(testCheck.substring(287, 291).replace(",", ".")));
    }
}