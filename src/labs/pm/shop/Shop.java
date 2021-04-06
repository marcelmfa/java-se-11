package labs.pm.shop;

import java.math.BigDecimal;

import labs.pm.data.Product;
import labs.pm.data.Rating;

public class Shop {
    public static void main(String[] args) {
        Product p1 = new Product(1l, "Tea", BigDecimal.valueOf(3.99), Rating.THREE_STARS);
        Product p2 = new Product(1l, "Coffee", BigDecimal.valueOf(4.99), Rating.FOUR_STARS);
        Product p3 = new Product(1l, "Chocolate", BigDecimal.valueOf(5.99), Rating.FIVE_STARS);
        Product p4 = p1.applyRating(Rating.ONE_STAR);
        printProduct(p1);
        printProduct(p2);
        printProduct(p3);
        printProduct(p4);
    }

    private static void printProduct(Product p1) {
        System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getPrice() + " " + p1.getDiscount() + " " + p1.getRating());
    }
}
