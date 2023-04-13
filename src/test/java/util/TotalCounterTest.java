package util;

import models.products.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TotalCounterTest {
    private List<Product> productList;

    @BeforeEach
    public void setUp() {
        Map<Integer, Integer> shopping = new LinkedHashMap<>();
        shopping.put(5, 7);
        shopping.put(7, 5);
        shopping.put(10, 2);

        productList = new ArrayList<>();
        productList.addAll(new ProductsFactory().getSupplies(shopping));
    }

    @Test
    public void countTotalSum() {
        assertEquals(93.87, TotalCounter.countTotalSum(productList));
    }
}