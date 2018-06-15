import java.util.LinkedList;
import java.util.List;

/**
 * Created by Noy on 5/20/2018.
 */
public class CourseController extends Controller {
    private static CourseController CourseControllerInstance = null;

    private CourseController()
    {
        System.out.println("Building CourseController for the first time...");
    }

    public static CourseController getInstance()
    {
        if (CourseControllerInstance == null)
            CourseControllerInstance = new CourseController();

        return CourseControllerInstance;
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


}
