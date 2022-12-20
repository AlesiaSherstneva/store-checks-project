package models.products;

import enums.ProductName;

public class DiscountProductImpl implements Product {
    private final Product product;

    public DiscountProductImpl(Product product) {
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
        return this.product.getPrice() * 0.95;
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
        return String.format("%8s %8.2f x %d %8.2f\n%30s\n",
                getProductName(),
                getPrice(),
                getCount(),
                getPrice() * getCount(),
                "5% discount (loyalty card)");
    }
}