import java.util.Date;

public class note {
    String info,WrittenBy;
    String date;
    questions question;

    public note(String info, String writtenBy, String date, questions question) {
        this.info = info;
        WrittenBy = writtenBy;
        this.date = date;
        this.question = question;
    }
}
