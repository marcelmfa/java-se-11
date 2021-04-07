package labs.pm.data;

@FunctionalInterface
public interface Rateable<T> {
    
    public static final Rating DEFAULT_RATING = Rating.NOT_RATED;

    T applyRating(Rating rating);

    default T applyRating(int stars) {
        return applyRating(convert(stars));
    }

    static Rating convert(int stars) {
        return stars >= 0 && stars < Rating.values().length ? Rating.values()[stars] : DEFAULT_RATING;
    }

    default Rating getRating() {
        return DEFAULT_RATING;
    }
}
