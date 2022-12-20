package models.products;

import enums.ProductName;

public interface Product {
    int getId();
    ProductName getProductName();
    double getPrice();
    boolean isOnSale();
    int getCount();
}