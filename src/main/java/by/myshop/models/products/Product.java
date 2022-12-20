package by.myshop.models.products;

import by.myshop.enums.ProductName;

public interface Product {
    int getId();
    ProductName getProductName();
    double getPrice();
    boolean isOnSale();
    int getCount();
}