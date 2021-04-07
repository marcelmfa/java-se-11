package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Drink extends Product {

    /**
     *
     */
    private static final LocalTime START_HAPPY_HOUR = LocalTime.of(17, 30);
    private static final LocalTime END_HAPPY_HOUR = LocalTime.of(18, 30);

    public Drink(long id, String name, BigDecimal price, Rating rating) {
        super(id, name, price, rating);
    }
   
    @Override
    public BigDecimal getDiscount() {
        LocalTime now = LocalTime.now();
        return now.isAfter(START_HAPPY_HOUR) && now.isBefore(END_HAPPY_HOUR) ? super.getDiscount() : BigDecimal.ZERO;
    }

    @Override
    public Product applyRating(Rating rating) {
        return new Drink(this.getId(), this.getName(), this.getPrice(), rating);
    }
}
