public class Favorite {
    private String title;
    private String author;
    private String genre;
    private int year;
    private String series;

    public Favorite(){
        this.title = "";
        this.author = "";
        this.genre = "";
        this.year = 0;
        this.series = "";

    }

    public Favorite(String title, String author, String genre, int year, String series) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }


}
