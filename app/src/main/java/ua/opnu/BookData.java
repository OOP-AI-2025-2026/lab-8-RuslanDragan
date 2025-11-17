package ua.opnu;

public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }


    public double getRating() {
        if (reviews == 0) return 0.0;
        return total / reviews;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public int compareTo(BookData other) {

        double myRating = this.getRating();
        double otherRating = other.getRating();


        int ratingComparison = Double.compare(otherRating, myRating);


        if (ratingComparison != 0) {
            return ratingComparison;
        }


        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return String.format("Книга: '%-20s' | Рейтинг: %.2f | Відгуків: %d",
                title, getRating(), reviews);
    }
}