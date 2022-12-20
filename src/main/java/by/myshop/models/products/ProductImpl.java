package by.myshop.models.products;

import by.myshop.enums.ProductName;

import java.io.Serializable;

public class ProductImpl implements Product, Serializable {
    private int id;
    private ProductName productName;
    private double price;
    private boolean onSale;
    private int count;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public ProductName getProductName() {
        return productName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isOnSale() {
        return onSale;
    }

    @Override
    public int getCount() {
        return count;
    }

    public static class Builder {
        private final ProductImpl newItem;

        public Builder() {
            newItem = new ProductImpl();
        }

        public Builder withId(int id) {
            newItem.id = id;
            return this;
        }

        public Builder withItemName(ProductName productName) {
            newItem.productName = productName;
            return this;
        }

        public Builder withPrice(double price) {
            newItem.price = price;
            return this;
        }

        public Builder withOnSale(boolean onSale) {
            newItem.onSale = onSale;
            return this;
        }

        public Builder withCount(int count) {
            newItem.count = count;
            return this;
        }

        public ProductImpl build() {
            return newItem;
        }
    }

    @Override
    public String toString() {
        return String.format("%8s %8.2f x %d %7.2f\n",
                getProductName(),
                getPrice(),
                getCount(),
                getPrice() * getCount());
    }
}