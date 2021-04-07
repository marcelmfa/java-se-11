package labs.pm.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public abstract class Product {

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

    public abstract Product applyRating(Rating rating);

    public LocalDate getBestBefore() {
        return LocalDate.now();
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price + " " + this.getDiscount() + " " + this.getRating();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // Checking class name
        // if (obj != null && getClass() != obj.getClass()){

        // Checking inheritance only
        if (obj instanceof Product) {
            final Product other = (Product) obj;
            return this.id == other.id;
        }        
        return false;
    }

    
}
