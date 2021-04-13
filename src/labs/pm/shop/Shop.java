package labs.pm.shop;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Locale;
import java.util.function.Predicate;

import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

public class Shop {
    public static void main(String[] args) {

        ProductManager pm = new ProductManager(Locale.US);
        pm.createProduct(1l, "Beer light", BigDecimal.valueOf(3.99), Rating.THREE_STARS);
        pm.printProductReport(1l);

        pm.changeLocale(Locale.UK.toLanguageTag());
        pm.createProduct(2l, "Imperial Stout Beer", BigDecimal.valueOf(5.99), Rating.FOUR_STARS);
        pm.reviewProduct(2l, Rating.FIVE_STARS, "Nice beer after a long work day");
        pm.reviewProduct(2l, Rating.ONE_STAR, "Too strong for me");        
        pm.reviewProduct(2l, Rating.THREE_STARS, "Its OK");
        //pm.printProductReport(2l);

        pm.createProduct(3l, "Heineken", BigDecimal.valueOf(1.99), Rating.FOUR_STARS);
        pm.reviewProduct(3l, Rating.FIVE_STARS, "Nice flavor");
        //pm.printProductReport(3l);

        Comparator<Product> nameAsc = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Comparator<Product> ratingDesc = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
        pm.printProducts(ratingDesc.thenComparing(nameAsc));

        pm.printProducts(ratingDesc.thenComparing(nameAsc.reversed()));
        
        pm.printProducts(ratingDesc.thenComparing(nameAsc).reversed());

        Predicate<Product> higherThreeStars = p -> p.getRating().ordinal() > 3;
        pm.printProducts(higherThreeStars, nameAsc);

        pm.getDiscounts()
            .forEach((rating, discount) -> System.out.println(rating + "\t" + discount));
        
        pm.parseProduct("X,4,Coffee,0.5,4,"); // wrong type
        pm.parseProduct("D,X,Coffee,0.5,4,"); // wrong id
        pm.parseProduct("D,X,Coffee,0.5,X,"); // wrong rating
        pm.parseProduct("D,4,Coffee,0.5,4,"); // OK!

        pm.parseReview("4,5,Usual everyday drink");

        // TODO Parse a food string
    }

}
