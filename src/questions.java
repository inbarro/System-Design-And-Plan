import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class questions {
    String WritenBy,body,difficult,estimatedTime,id;
    questionBank maagar;
    LinkedList<choise> choises;
    questionBank questionBank;
    List<note> notes;
    LinkedList <QuestionInTest> questionInTests;

    public questions(String writenBy, String body, String difficult, String estimatedTime, String id, questionBank maagar) {
        WritenBy = writenBy;
        this.body = body;
        this.difficult = difficult;
        this.estimatedTime = estimatedTime;
        this.id = id;
        this.maagar = maagar;
        this.choises = null;
        this.notes = new ArrayList<>();
    }

    public void noteCrude(){}
    public void optionCrude(){}
    public String culculateEstimateTime(){
        return estimatedTime ;
    }
    public void questionCrud(){}

}
