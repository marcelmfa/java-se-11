package labs.pm.data;

public class Review implements Comparable<Review> {
    
    private String comments;

    private Rating rating;

    Review(String comments, Rating rating) {
        this.comments = comments;
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public Rating getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Review [comments=" + comments + ", rating=" + rating.getStars() + "]";
    }

    @Override
    public int compareTo(Review o) {
        return o.getRating().ordinal() - this.getRating().ordinal();
    }
}
