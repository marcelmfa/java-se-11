package labs.pm.data;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Set;

public class ProductManager {

    private Locale locale;
    private ResourceBundle bundle;
    private DateTimeFormatter dateFormat;
    private NumberFormat moneyFormat;

    private Map<Product, List<Review>> products = new HashMap<>();

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
        Product product = new Drink(id,name, price, rating);
        products.putIfAbsent(product, new ArrayList<>());
        return product;
    }

    public Product createProduct(long id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        Product product = new Food(id,name, price, rating, bestBefore);
        products.putIfAbsent(product, new ArrayList<>());
        return product;
    }

    public Product reviewProduct(Product product, Rating rating, String comments) {
        
        List<Review> reviews = products.get(product);
        products.remove(product, reviews);
        reviews.add(new Review(comments, rating));

        int sumRatings = 0;
        for (Review review: reviews) {
            sumRatings += review.getRating().ordinal();
        }

        product = product.applyRating(Math.round((float) sumRatings / reviews.size()));
        products.put(product, reviews);
        return product;
    }

    public Product findProduct(long id) {
        Set<Product> keySet = products.keySet();
        for (Product p : keySet) {
            if (Objects.equals(id, p.getId())) {
                return p;
            }
        }
        return null;        
    }

    public Product reviewProduct(long id, Rating rating, String comments) {
        return reviewProduct(findProduct(id), rating, comments);
    }

    public void printProductReport(long id) {
        printProductReport(findProduct(id));
    }

    public void printProductReport(Product product) {
        List<Review> reviews = products.get(product);
        StringBuilder buffer = new StringBuilder()
            .append(MessageFormat.format(bundle.getString("product"), 
                product.getName(), moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore())))
            .append("\n");
        

        if (reviews.isEmpty()) {
            buffer.append(bundle.getString("review.not")).append("\n");
        } else {
            
            Collections.sort(reviews);

            for (Review review: reviews) {
                buffer.append(MessageFormat.format(bundle.getString("review.done"), review.getRating().getStars(), review.getComments()))
                    .append("\n");
            }
        }        
        
        System.out.println(buffer);
    }

}
