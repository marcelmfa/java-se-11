package labs.pm.data;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    private long id;

    private String name;

    private BigDecimal price;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
    }
}
