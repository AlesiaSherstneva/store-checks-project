package printers;

import models.products.DiscountProductImpl;
import models.products.Product;
import models.products.OnSaleProductImpl;
import util.ProductsFactory;
import util.TotalCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckPrinter {
    public String printCheck(Map<Integer, Integer> shopping, boolean cardIsPresent) {
        List<Product> productListWithoutDiscount = new ProductsFactory().getSupplies(shopping);
        List<Product> productListWithDiscount = new ArrayList<>();

        double totalDiscount = TotalCounter.countTotalSum(productListWithoutDiscount);

        for (Product product : productListWithoutDiscount) {
            if (product.getCount() >= 5 && product.isOnSale()) {
                product = new OnSaleProductImpl(product);
            } else if (cardIsPresent) {
                product = new DiscountProductImpl(product);
            }
            productListWithDiscount.add(product);
        }
        double total = TotalCounter.countTotalSum(productListWithDiscount);
        totalDiscount -= total;

        return new CheckMaker().getCheck(productListWithDiscount, total, totalDiscount).toString();
    }
}