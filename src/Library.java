public class Library {
    private String title;
    private String author;
    private String rented;
    private String due;

    public Library(){
        this.title = "";
        this.author = "";
        this.rented = "";
        this.due = "";

    }

    public Library(String title, String author, String rented, String due) {
        this.title = title;
        this.author = author;
        this.rented = rented;
        this.due = due;
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

    public String getRented() {
        return rented;
    }

    public void setRented(String rented) {
        this.rented = rented;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }



}

