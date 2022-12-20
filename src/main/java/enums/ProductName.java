package enums;

public enum ProductName {
    BREAD(2.24, false),
    SUGAR(3.88, true),
    SALT(0.78, false),
    MEAT(15.67, false),
    CHICKEN(8.15, false),
    EGGS(3.45, true),
    RICE(5.32, true),
    PASTA(4.30, true),
    MILK(1.93, false),
    TEA(5.11, true),
    COFFEE(12.69, false),
    LEMONADE(2.52, true),
    BEER(4.34, false);

    final double price;
    final boolean onSale;

    ProductName(double price, boolean onSale) {
        this.price = price;
        this.onSale = onSale;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOnSale() {
        return onSale;
    }
}