import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class questionBank
{
   String AverageDifficult,AverageEstimatedTime,id;
   List<questions> questions;
   course course;

    public questionBank(String averageDifficult, String averageEstimatedTime, String id, course course) {
        AverageDifficult = averageDifficult;
        AverageEstimatedTime = averageEstimatedTime;
        this.id = id;
        this.questions = new ArrayList<>();
        this.course = course;
    }

    public String calculateAverageDifficult(){
        return AverageDifficult;
    }
    public String calculateAverageEstimatedTime(){
        return  AverageEstimatedTime;
    }
    public void addQuestion(){}
    public List<questions> getAllQuestions(){
        List<questions>q = new LinkedList<>();
        return q ;
    }
}
