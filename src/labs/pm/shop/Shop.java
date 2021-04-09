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
        pm.printProductReport(1l);

        ProductManager pm2 = new ProductManager(Locale.UK);
        pm2.createProduct(2l, "Imperial Stout Beer", BigDecimal.valueOf(5.99), Rating.FOUR_STARS);
        pm2.printProductReport(2l);
        
        pm2.reviewProduct(2l, Rating.FIVE_STARS, "Nice beer after a long work day");
        pm2.printProductReport(2l);
        
        pm2.reviewProduct(2l, Rating.ONE_STAR, "Too strong for me");
        pm2.printProductReport(2l);

        pm2.reviewProduct(2l, Rating.THREE_STARS, "Its OK");
        pm2.printProductReport(2l);

        pm2.createProduct(3l, "Heineken", BigDecimal.valueOf(1.99), Rating.FOUR_STARS);
        pm2.printProductReport(3l);
        
        pm2.reviewProduct(3l, Rating.FIVE_STARS, "Nice flavor");
        pm2.printProductReport(3l);
    }

}
