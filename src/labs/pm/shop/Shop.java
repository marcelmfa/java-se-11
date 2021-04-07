package labs.pm.shop;

import java.math.BigDecimal;
import java.time.LocalDate;

import labs.pm.data.Drink;
import labs.pm.data.Food;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

public class Shop {
    public static void main(String[] args) {
        
        ProductManager pm = new ProductManager();

        Product p1 = pm.createProduct(1l, "Tea", BigDecimal.valueOf(3.99), Rating.THREE_STARS);
        Product p2 = pm.createProduct(1l, "Coffee", BigDecimal.valueOf(4.99), Rating.FOUR_STARS);
        Product p3 = pm.createProduct(1l, "Chocolate", BigDecimal.valueOf(5.99), Rating.FIVE_STARS, LocalDate.now().plusDays(100l));
        Product p4 = p1.applyRating(Rating.ONE_STAR);
        Product p5 = pm.createProduct(1l, "Salt", BigDecimal.valueOf(0.05), Rating.NOT_RATED);
        printProduct(p1);
        printProduct(p2);
        printProduct(p3);
        printProduct(p4);
        printProduct(p5);
    }

    private static void printProduct(Product p1) {
        System.out.println(p1);
    }
}
