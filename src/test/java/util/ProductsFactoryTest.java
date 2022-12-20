package util;

import enums.ProductName;
import models.products.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductsFactoryTest {
    Map<Integer, Integer> shopping;

    @BeforeEach
    void setUp() {
        shopping = new LinkedHashMap<>();
        shopping.put(5, 1);
        shopping.put(1, 5);
        shopping.put(10, 3);
    }

    @Test
    void getSuppliesTest() {
        ProductsFactory productsFactory = new ProductsFactory();
        List<Product> productList = productsFactory.getSupplies(shopping);
        assertEquals(3, productList.size());
        assertEquals(ProductName.CHICKEN, productList.get(0).getProductName());
        assertEquals(5, productList.get(1).getCount());
    }
}