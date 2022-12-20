package by.myshop.printers;

import by.myshop.models.products.DiscountProductImpl;
import by.myshop.models.products.Product;
import by.myshop.models.products.OnSaleProductImpl;
import by.myshop.util.ProductsFactory;
import by.myshop.util.TotalCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckPrinter {
    public String printCheck(Map<Integer, Integer> shopping, boolean cardIsPresent) {
        List<Product> productListWithoutDiscount = new ProductsFactory().getSupplies(shopping);
        List<Product> productListWithDiscount = new ArrayList<>();

        double total = TotalCounter.countTotalSum(productListWithoutDiscount);

        for (Product product : productListWithoutDiscount) {
            if (product.getCount() >= 5 && product.isOnSale()) {
                product = new OnSaleProductImpl(product);
            } else if (cardIsPresent) {
                product = new DiscountProductImpl(product);
            }
            productListWithDiscount.add(product);
        }

        double totalDiscount = total - TotalCounter.countTotalSum(productListWithDiscount);

        return new CheckMaker().getCheck(productListWithDiscount, total, totalDiscount).toString();
    }
}