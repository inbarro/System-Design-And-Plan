import java.util.LinkedList;
import java.util.List;

public class questionBank
{
   double AverageDifficult,AverageEstimatedTime;

    LinkedList<questions> questions;
    course course;

    public double calculateAverageDifficult(){
        return AverageDifficult;
    }
    public double calculateAverageEstimatedTime(){
        return  AverageEstimatedTime;
    }
    public void addQuestion(){}
    public List<questions> getAllQuestions(){
        List<questions>q = new LinkedList<>();
        return q ;
    }
}
