package by.myshop.printers;

import by.myshop.models.products.Product;
import by.myshop.util.ProductsFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CheckMakerTest {
    List<Product> productList;
    double total, totalDiscount;

    @BeforeEach
    void setUp() {
        productList = new ArrayList<>();
        Map<Integer, Integer> shopping = new HashMap<>();
        shopping.put(11, 5);
        shopping.put(13, 8);
        ProductsFactory productsFactory = new ProductsFactory();
        productList.addAll(productsFactory.getSupplies(shopping));
        total = 98.17;
    }


    @Test
    void getCheckTest() {
        CheckMaker testCheckMaker = new CheckMaker();
        StringBuilder testCheck = testCheckMaker.getCheck(productList, total, totalDiscount);

        assertNotNull(testCheck);
        assertEquals("COFFEE", testCheck.substring(110, 116));
        assertEquals("BEER", testCheck.substring(142, 146));
        assertEquals(98.17, Double.parseDouble(testCheck.substring(225, 230).replace(",", ".")));
        assertEquals(0.00, Double.parseDouble(testCheck.substring(257, 261).replace(",", ".")));
    }
}