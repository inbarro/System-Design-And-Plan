import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Noy on 5/20/2018.
 */
public class CourseCharger implements Charger   {
    private static CourseCharger courseChargerInstance = null;

    private CourseCharger()
    {
        System.out.println("Building CourseCharger for the first time...");
    }

    public static CourseCharger getInstance()
    {
        if (courseChargerInstance == null)
            courseChargerInstance = new CourseCharger();

        return courseChargerInstance;
    }

    course course;

    public List<questions> getQuestionFromCourse (int courseID){
        List<questions> q = new LinkedList<>();
        return  q ;
    }
    public List<course> getAllCourses (){
        List<course> c = new LinkedList<>();
        return  c ;
    }
    public void enterIDForCourse (int courseID){}
    public void saveCourse(List <String> param){}
    public void confirmExam (int ExamID, int courseID){}
    public void addSyllabus (int courseID, String syllabus){}
    public List<Test> getExceptionsExams (int examID,int courseID){
        List<Test> t = new LinkedList<>();
        return  t ;
    }
    public List<Test> getWaitingExamsToBeApprove (int courseID){
        List<Test> t = new LinkedList<>();
        return  t ;
    }


    @Override
    public void saveToDB(String type, Object o) {

    }

    @Override
    public void deleteFromDB(String type, int ID) {

    }

    @Override
    public void updateDB(String type, int id, Object New) {

    }


    public String CoursenameToID(String coursename){
        List<HashMap<String, String>> a = DBUtils.executeQuery(String.format(String.format("Select * from course where name = '%s'; ",coursename)));
        String id =  a.get(0).get("id");
        return id;
    }

    public List<HashMap<String, String>> seeCourses(String id) {
        return DBUtils.executeQuery(String.format("Select name from course where incharge = '%s'; ",id));
    }
}