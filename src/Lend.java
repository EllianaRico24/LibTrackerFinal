public class Lend {
    private String title;
    private String person;
    private String lended;
    private String due;

    public Lend(){
        this.title = "";
        this.person = "";
        this.lended = "";
        this.due = "";

    }

    public Lend(String title, String person, String lended, String due) {
        this.title = title;
        this.person = person;
        this.lended = lended;
        this.due = due;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getLended() {
        return lended;
    }

    public void setLended(String lended) {
        this.lended = lended;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }



}





