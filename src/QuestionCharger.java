import java.util.LinkedList;
import java.util.List;

/**
 * Created by Noy on 5/20/2018.
 */
public class QuestionCharger extends Observable implements Charger {
    private static QuestionCharger questionChargerInstance = null;

    questions question ;

    //Constructor
    private QuestionCharger()
    {
        System.out.println("Building QuestionCharger for the first time...");
    }

    public static QuestionCharger getInstance()
    {
        if (questionChargerInstance == null)
            questionChargerInstance = new QuestionCharger();

        return questionChargerInstance;
    }



    //Methds
    public void saveQuestion (List<questions> params){}
    public questions getQuestion (int questionID){return question;}
    public List<questions> getAllQuestion (){
        List<questions> q = new LinkedList<>();
        return  q ;
    }
    public questions getQuestionByText (String s){return  question;}
    public void enterIdForQuestion (int questionID){}
    public void addOption (int questionID, String option){}
    public void deleteOption (int questionID, int optionID){}
    public void addNote (int questionID, String note){}
    public note getNote (int questionID, int noteID){
        note n  = new note();
        return n ;
    }
    public List<String> getQuestionOptions (){
        List<String> q = new LinkedList<>();
        return  q ;
    }
    public void editOptions (int courseID, int OptionID, String newOption){}

    @Override
    public void saveToDB(String type, Object o) {

    }

    @Override
    public void deleteFromDB(String type, int ID) {

    }

    @Override
    public void updateDB(String type, int id, Object New) {

    }
}
