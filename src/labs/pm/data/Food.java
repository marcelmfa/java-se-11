package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Food extends Product {
    
    private LocalDate bestBefore;

    Food(long id, String name, BigDecimal price, Rating rating) {
        super(id, name, price, rating);
    }

    Food(long id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        this(id, name, price, rating);
        this.bestBefore = bestBefore;
    }

    @Override
    public LocalDate getBestBefore() {
        return bestBefore;
    }

    @Override
    public String toString() {
        if (bestBefore == null) {
            return super.toString();
        }
        return super.toString() + ", " + this.bestBefore;
    }

    @Override
    public BigDecimal getDiscount() {        
        if (bestBefore == null) {
            return BigDecimal.ZERO;
        }
        LocalDate now = LocalDate.now();
        return now.isEqual(bestBefore) || now.isAfter(bestBefore) ? super.getDiscount() : BigDecimal.ZERO;
    }

    @Override
    public Product applyRating(Rating rating) {
        return new Food(this.getId(), this.getName(), this.getPrice(), rating, bestBefore);
    }
}
