package labs.pm.shop;

import java.math.BigDecimal;

import labs.pm.data.Product;

public class Shop {
    public static void main(String[] args) {
        Product p1 = new Product();
        p1.setId(1l);
        p1.setName("Tea");
        p1.setPrice(BigDecimal.valueOf(3.99));
        printProduct(p1);
    }

    private static void printProduct(Product p1) {
        System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getPrice() + " " + p1.getDiscount());
    }
}
