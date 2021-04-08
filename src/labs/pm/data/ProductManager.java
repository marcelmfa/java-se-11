package labs.pm.data;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductManager {

    private Locale locale;
    private ResourceBundle bundle;
    private DateTimeFormatter dateFormat;
    private NumberFormat moneyFormat;

    private Product product;
    private Review[] reviews = new Review[5];

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
        if (isReviewsFullCapacity()) {
            increaseReviewsCapacity();
        }

        int sumRatings = 0, numReviews = 0;
        boolean reviewed = false;
        while (numReviews < reviews.length && !reviewed) {
            if (reviews[numReviews] == null) {
                reviews[numReviews] = new Review(comments, rating);
                reviewed = true;
            }

            sumRatings += reviews[numReviews].getRating().ordinal();
            numReviews++;
        }

        this.product = product.applyRating(Math.round((float) sumRatings / numReviews));
        return this.product;
    }

    private boolean isReviewsFullCapacity() {
        return reviews[reviews.length - 1] != null;
    }

    private void increaseReviewsCapacity() {
        reviews = Arrays.copyOf(reviews, reviews.length + 5);
    }

    public void printProductReport() {
        StringBuilder buffer = new StringBuilder()
            .append(MessageFormat.format(bundle.getString("product"), 
                product.getName(), moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore())))
            .append("\n");
        

        if (isEmptyReviews()) {
            buffer.append(bundle.getString("review.not")).append("\n");
        } else {
            for (Review review: reviews) {
                if (review != null) {
                    buffer.append(MessageFormat.format(bundle.getString("review.done"), review.getRating().getStars(), review.getComments()))
                        .append("\n");
                }
            }
        }        
        
        System.out.println(buffer);
    }

    private boolean isEmptyReviews() {
        return reviews[0] == null;
    }
}
