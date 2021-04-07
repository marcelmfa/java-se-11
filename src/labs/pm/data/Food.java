package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Food extends Product {
    
    private LocalDate bestBefore;

    public Food(long id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        super(id, name, price, rating);
        this.bestBefore = bestBefore;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }
    @Override
    public String toString() {
        return super.toString() + ", " + this.bestBefore;
    }

    @Override
    public BigDecimal getDiscount() {        
        LocalDate now = LocalDate.now();
        return now.isEqual(bestBefore) || now.isAfter(bestBefore) ? super.getDiscount() : BigDecimal.ZERO;
    }

    @Override
    public Product applyRating(Rating rating) {
        return new Food(this.getId(), this.getName(), this.getPrice(), rating, bestBefore);
    }
}
