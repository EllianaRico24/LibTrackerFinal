public class Wish {
    private String title;
    private String author;
    private double cost;
    private String series;

    public Wish(){
        this.title = "";
        this.author = "";
        this.cost = 0.00;
        this.series = "";

    }

    public Wish(String title, String author, double cost, String series) {
        this.title = title;
        this.author = author;
        this.cost = cost;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }


}

