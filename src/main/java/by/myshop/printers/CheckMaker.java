package by.myshop.printers;

import by.myshop.models.products.Product;

import java.util.Date;
import java.util.List;

public class CheckMaker {
    public StringBuilder getCheck(List<Product> productList, double total, double totalDiscount) {
        String LINE = "-------------------------------";

        StringBuilder check = new StringBuilder()
                .append(LINE).append(String.format("\n%17s", "CHECK"))
                .append(String.format("\n%25s\n", new Date().toString().substring(0, 20)))
                .append(LINE).append("\n");
        for (Product product : productList) {
            check.append(product);
        }
        check.append(LINE).append(String.format("\n%20s%10.2f", "TOTAL", total))
                .append(String.format("\n%20s%10.2f\n", "total discount", totalDiscount))
                .append(LINE).append(String.format("\n%s\n", "THANK YOU FOR CHOOSING OUR SHOP"))
                .append(LINE);
        return check;
    }
}