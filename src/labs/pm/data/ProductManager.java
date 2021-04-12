package labs.pm.data;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ProductManager {

    private static final Logger LOG = Logger.getLogger(ProductManager.class.getName());

    private Map<Product, List<Review>> products = new HashMap<>();
    private ResourceFormatter formatter;

    private static Map<String, ResourceFormatter> formatters = Map.of(
        "en-GB", new ResourceFormatter(Locale.UK),
        "en-US", new ResourceFormatter(Locale.US),
        "fr-FR", new ResourceFormatter(Locale.FRANCE),
        "ru-RU", new ResourceFormatter(new Locale("ru", "RU")),
        "zh-CN", new ResourceFormatter(Locale.CHINA)
    );

    public ProductManager(Locale locale) {
        changeLocale(locale.toLanguageTag());
    }

    public ProductManager(String languageTag) {
        changeLocale(languageTag);
    }

    public void changeLocale(String languageTag) {
        formatter = formatters.getOrDefault(languageTag, formatters.get("en-GB"));
    }

    public Set<String> getSupportedLocales() {
        return formatters.keySet();
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

        product = product.applyRating(
            (int) Math.round(reviews.stream()
                .mapToInt(r -> r.getRating().ordinal())
                .average()
                .orElse(0)));
        products.put(product, reviews);
        return product;
    }

    public Product findProduct(long id) throws ProductManagerException {
        return products.keySet()
            .stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElseThrow(() -> new ProductManagerException("Product with id " + id + " not found!"));
            // retornar null quando não encontrado
            //.orElseGet(() -> null);
    }

    public Product reviewProduct(long id, Rating rating, String comments) {
        try {
            return reviewProduct(findProduct(id), rating, comments);
        } catch (ProductManagerException e) {
            LOG.log(Level.INFO, null, e);
        }
        return null;
    }

    public void printProductReport(long id) {
        try {
            printProductReport(findProduct(id));
        } catch (ProductManagerException e) {
            LOG.log(Level.INFO, null, e);
        }
    }

    public void printProductReport(Product product) {
        List<Review> reviews = products.get(product);
        Collections.sort(reviews);

        StringBuilder buffer = new StringBuilder()
            .append(formatter.formatProduct(product))
            .append("\n");        

        if (reviews.isEmpty()) {
            buffer.append(formatter.formatNotReviewed()).append("\n");
        } else {
            
            buffer.append(reviews.stream()
                .map(r -> formatter.formatReview(r) + "\n")
                .collect(Collectors.joining())
            );
        }        
        
        System.out.println(buffer);
    }

    public void printProducts(Comparator<Product> productComparator) {
        StringBuilder buffer = new StringBuilder()
            .append(products.keySet()
                .stream()
                .sorted(productComparator)
                .map(p -> formatter.formatProduct(p) + "\n")
                .collect(Collectors.joining())
            );

        System.out.println(buffer);
    }

    public void printProducts(Predicate<Product> filter, Comparator<Product> productComparator) {
        StringBuilder buffer = new StringBuilder()
            .append(products.keySet()
                .stream()
                .filter(filter)
                .sorted(productComparator)
                .map(p -> formatter.formatProduct(p) + "\n")
                .collect(Collectors.joining())
            );

        System.out.println(buffer);        
    }

    public Map<String, String> getDiscounts() {
        return products.keySet()
            .stream()
            .collect(Collectors.groupingBy(
                product -> product.getRating().getStars(),
                Collectors.collectingAndThen(
                    Collectors.summingDouble(p -> p.getDiscount().doubleValue()),
                    discount -> formatter.moneyFormat.format(discount)
                )
            ));
    }

    public static class ResourceFormatter {

        private Locale locale;
        private ResourceBundle bundle;
        private DateTimeFormatter dateFormat;
        private NumberFormat moneyFormat;
        
        public ResourceFormatter(Locale locale) {
            this.locale = locale;

            bundle = ResourceBundle.getBundle("labs.pm.data.resources", this.locale);
            dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                .localizedBy(this.locale);
            moneyFormat = NumberFormat.getCurrencyInstance(this.locale);
        }

        public String formatProduct(Product product) {
            return MessageFormat.format(bundle.getString("product"), 
                product.getName(), moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore()));
        }

        public String formatNotReviewed() {
            return bundle.getString("review.not");
        }

        public String formatReview(Review review) {
            return MessageFormat.format(bundle.getString("review.done"), 
                review.getRating().getStars(), review.getComments());
        }
    }

}
