package printers;

import enums.ProductName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CheckPrinterTest {
    private final CheckPrinter printer;

    private String testCheck;
    private Map<Integer, Integer> shopping;

    double price, discount;

    public CheckPrinterTest() {
        printer = new CheckPrinter();
    }

    @BeforeEach
    public void setUp() {
        shopping = new LinkedHashMap<>();
    }

    @Test
    public void checkWithDiscountCardTest() {
        shopping.put(8, 1);

        testCheck = printer.printCheck(shopping, true);

        assertTrue(testCheck.contains("5% discount (loyalty card)"));
        assertFalse(testCheck.contains("10% discount (promotion)"));

        price = ProductName.PASTA.getPrice() * shopping.get(8) * 0.95;
        assertTrue(testCheck.contains(String.format("%.2f",  price)));

        discount = ProductName.PASTA.getPrice() * shopping.get(8) - price;
        assertTrue(testCheck.contains(String.format("%.2f", discount)));
    }

    @Test
    public void checkWithPromotionDiscountTest() {
        shopping.put(10, 5);

        testCheck = printer.printCheck(shopping, false);

        assertFalse(testCheck.contains("5% discount (loyalty card)"));
        assertTrue(testCheck.contains("10% discount (promotion)"));

        price = ProductName.TEA.getPrice() * shopping.get(10) * 0.9;
        assertTrue(testCheck.contains(String.format("%.2f",  price)));

        discount = ProductName.TEA.getPrice() * shopping.get(10) - price;
        assertTrue(testCheck.contains(String.format("%.2f", discount)));
    }

    @Test
    public void checkWithoutAllDiscountsTest() {
        shopping.put(2, 4);

        testCheck = printer.printCheck(shopping, false);

        assertFalse(testCheck.contains("5% discount (loyalty card)"));
        assertFalse(testCheck.contains("10% discount (promotion)"));

        price = ProductName.SUGAR.getPrice() * shopping.get(2);
        assertTrue(testCheck.contains(String.format("%.2f",  price)));

        discount = ProductName.SUGAR.getPrice() * shopping.get(2) - price;
        assertTrue(testCheck.contains(String.format("%.2f", discount)));
    }
}