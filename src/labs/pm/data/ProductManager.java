package labs.pm.data;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductManager {

    private Locale locale;
    private ResourceBundle bundle;
    private DateTimeFormatter dateFormat;
    private NumberFormat moneyFormat;

    private Product product;
    private Review review;

    public ProductManager() {
        this(Locale.getDefault());
    }

    public ProductManager(Locale locale) {
        this.locale = locale;

        bundle = ResourceBundle.getBundle("labs.pm.data.resources", this.locale);
        dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
            .localizedBy(this.locale);
        moneyFormat = NumberFormat.getCurrencyInstance(this.locale);
    }
    
    public Product createProduct(long id, String name, BigDecimal price, Rating rating) {
        product = new Drink(id,name, price, rating);
        return product;
    }

    public Product createProduct(long id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        product = new Food(id,name, price, rating, bestBefore);
        return product;
    }

    public Product reviewProduct(Product product, Rating rating, String comments) {
        this.review = new Review(comments, rating);
        this.product = product.applyRating(rating);
        return this.product;
    }

    public void printProductReport() {
        StringBuilder buffer = new StringBuilder()
            .append(MessageFormat.format(bundle.getString("product"), 
                product.getName(), moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore())))
            .append("\n");
        
        String reviewMsg = review == null
            ? bundle.getString("review.not")
            : MessageFormat.format(bundle.getString("review.done"), review.getRating().getStars(), review.getComments());
        buffer.append(reviewMsg)
            .append("\n");
        
        System.out.println(buffer);
    }

}
