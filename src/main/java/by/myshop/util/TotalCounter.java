package by.myshop.util;

import by.myshop.models.products.Product;

import java.util.List;

public class TotalCounter {
    public static double countTotalSum(List<Product> productList) {
        double totalSum = 0;
        for(Product product : productList) {
            totalSum += product.getPrice() * product.getCount();
        }
        return totalSum;
    }
}
