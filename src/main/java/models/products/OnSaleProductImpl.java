package models.products;

import enums.ProductName;

import java.util.Locale;

public class OnSaleProductImpl implements Product {
    private final Product product;

    public OnSaleProductImpl(Product product) {
        this.product = product;
    }

    @Override
    public int getId() {
        return this.product.getId();
    }

    @Override
    public ProductName getProductName() {
        return this.product.getProductName();
    }

    @Override
    public double getPrice() {
        return Double.parseDouble
                (String.format(Locale.ENGLISH,"%.2f",this.product.getPrice() * 0.9));
    }

    @Override
    public boolean isOnSale() {
        return this.product.isOnSale();
    }

    @Override
    public int getCount() {
        return this.product.getCount();
    }

    @Override
    public String toString() {
        return product + String.format("%30s\n", "10% discount (promotion)");
    }
}