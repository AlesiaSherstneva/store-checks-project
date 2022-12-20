package by.myshop.models.products;

import by.myshop.enums.ProductName;

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
        return this.product.getPrice() * 0.9;
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
                "10% discount (promotion)");
    }
}