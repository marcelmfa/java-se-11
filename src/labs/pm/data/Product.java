package labs.pm.data;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    private long id;

    private String name;

    private BigDecimal price;

    private Rating rating;

    public Product(long id, String name, BigDecimal price) {
        this(id, name, price, Rating.NOT_RATED);
    }

    public Product(long id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    public String getRating() {
        return rating.getStars();
    }

    public Product applyRating(Rating rating) {
        return new Product(this.id, this.name, this.price, rating);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price + " " + this.getDiscount() + " " + this.getRating();
    }

}
