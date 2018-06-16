import java.util.*;

/**
 * Created by Noy on 5/20/2018.
 */
public class QuestionCharger implements Charger {
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

    public List<questions> QuestionsOfCourse(questionBank maagar) {
        List<HashMap<String,String>> result =  DBUtils.executeQuery(String.format("Select * from questions where maagarID ='%s';",maagar.id));
        List<questions> questions = new ArrayList<>();
        for(int i = 0;i<result.size();i++)
        {
            questions q = new questions(result.get(i).get("writtenBy"),result.get(i).get("body"),result.get(i).get("difficulty"),result.get(i).get("time"),result.get(i).get("id"),maagar);
            List<HashMap<String,String>> resultNotes =  DBUtils.executeQuery(String.format("Select * from notes where queID ='%s';",q.id));
            for(int j =0;j<resultNotes.size();j++)
            {
                HashMap<String,String> note = resultNotes.get(j);
                q.notes.add(new note(note.get("info"),note.get("writtenBy"),note.get("date"),q));
            }

            questions.add(q);

        }
        maagar.questions = questions;

        return questions;

    }

    public void DeleteQuestion(String question) {
        DBUtils.executeQuery(String.format("delete from questions where body ='%s';",question));
    }

    public questionBank getMaagar(course course) {
        List<HashMap<String, String>> result = DBUtils.executeQuery(String.format("Select * from maagar where courseID = '%s';",course.ID));

        questionBank maagar = new questionBank(result.get(0).get("avg_diff"),result.get(0).get("avg_time"),result.get(0).get("id"),course);

        return maagar;
    }

    public void AddNoteToQuestion(questions question,String note,user user) {
        Date date = new Date();
        note n = new note(note,user.ID,date.toString(),question);
        DBUtils.executeQuery(String.format("INSERT INTO notes (queID, info, writtenBY,date)\n" +
                "VALUES ('%s', '%s', '%s', '%s');",question.id,note,user.ID,date.toString()));
        question.notes.add(n);

    }

    public void WriteQuestion(course courseInCrew,String body,String user) {
        questionBank maagar = getMaagar(courseInCrew);
        String rand = String.valueOf(Math.abs(new Random(System.currentTimeMillis()).nextInt()));
        maagar.questions.add(new questions(user,body,"5","10",rand.toString(),maagar));
        DBUtils.executeQuery(String.format("INSERT INTO questions (id, body, difficulty,time,writtenBy,maagarID)\n" +
                "VALUES ('%s', '%s', '%s', '%s', '%s', '%s');",rand,body,"5","10",user,maagar.id));
    }
}
