package labs.pm.shop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

import labs.pm.data.Drink;
import labs.pm.data.Food;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

public class Shop {
    public static void main(String[] args) {
        
        ProductManager pm = new ProductManager(Locale.US);
        pm.createProduct(1l, "Beer light", BigDecimal.valueOf(3.99), Rating.THREE_STARS);
        pm.printProductReport();

        ProductManager pm2 = new ProductManager(Locale.UK);
        Product p2 = pm2.createProduct(1l, "Imperial Stout Beer", BigDecimal.valueOf(5.99), Rating.FOUR_STARS);
        pm2.printProductReport();
        pm2.reviewProduct(p2, Rating.FIVE_STARS, "Nice beer after a long work day");
        pm2.printProductReport();
    }

}
