package printers;

import enums.ProductName;
import models.products.Product;
import util.ProductsFactory;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CheckMakerTest {
    private final List<Product> productList;

    public CheckMakerTest() {
        productList = new ArrayList<>();

        Map<Integer, Integer> shopping = new HashMap<>();
        shopping.put(11, 5);
        shopping.put(13, 8);

        ProductsFactory productsFactory = new ProductsFactory();
        productList.addAll(productsFactory.getSupplies(shopping));
    }

    @Test
    public void getCheckTest() {
        double total = 98.17;
        double totalDiscount = 0;

        StringBuilder testCheck = new CheckMaker().getCheck(productList, total, totalDiscount);

        assertNotNull(testCheck);

        assertTrue(testCheck.toString().contains(ProductName.COFFEE.name()));
        assertTrue(testCheck.toString().contains(ProductName.BEER.name()));

        assertTrue(testCheck.toString().contains(String.format("%.2f", total)));
        assertTrue(testCheck.toString().contains(String.format("%.2f", totalDiscount)));
    }
}