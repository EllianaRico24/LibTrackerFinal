public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;
    private String rating;
    private String series;

    public Book(){
        this.title = "";
        this.author = "";
        this.genre = "";
        this.year = 0;
        this.rating = "";
        this.series = "";

    }

    public Book(String title, String author, String genre, int year, String rating, String series) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.series = series;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }


}
