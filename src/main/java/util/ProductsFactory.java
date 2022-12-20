package util;

import enums.ProductName;
import models.products.Product;
import models.products.ProductImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ProductsFactory {
    public List<Product> getSupplies(Map<Integer, Integer> shopping) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : shopping.entrySet()) {
            ProductName productName = Arrays.stream(ProductName.values())
                    .filter(o -> o.ordinal() + 1 == entry.getKey())
                    .findAny().orElse(null);
            if (productName == null) {
                System.out.println("Unknown item!");
                System.exit(1);
            } else {
                Product product = new ProductImpl.Builder()
                        .withId(productName.ordinal() + 1)
                        .withItemName(productName)
                        .withPrice(productName.getPrice())
                        .withOnSale(productName.isOnSale())
                        .withCount(entry.getValue())
                        .build();
                productList.add(product);
            }
        }
        return productList;
    }
}