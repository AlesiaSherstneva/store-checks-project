package util;

import enums.ProductName;
import models.products.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ProductsFactoryTest {
    private Map<Integer, Integer> shopping;
    private ProductsFactory productsFactory;

    @BeforeEach
    public void setUp() {
        Random random = new Random();

        shopping = new LinkedHashMap<>();
        while (shopping.keySet().size() != 3) {
            shopping.put(random.nextInt(12) + 1, random.nextInt(9) + 1);
        }

        productsFactory = new ProductsFactory();
    }

    @Test
    public void getSuppliesTest() {
        List<Product> productList = productsFactory.getSupplies(shopping);

        assertEquals(3, productList.size());
        for (Product product : productList) {
            assertInstanceOf(ProductName.class, product.getProductName());
            assertEquals(product.getCount(), shopping.get(product.getProductName().ordinal() + 1));
        }
    }
}