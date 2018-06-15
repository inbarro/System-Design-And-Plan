import java.util.HashMap;
import java.util.List;

public class Model {
    UserCharger UC;
    CourseCharger CC;
    QuestionCharger QC;
    Controller c;

    public Model() {
         UC = UserCharger.getInstance();
         CC = CourseCharger.getInstance();
         QC = QuestionCharger.getInstance();
    }


    public void SetController(Controller c) {
        this.c = c;
    }

    public boolean Login(String username, String password) {
        return UC.Login(username,password);
    }

    public List<HashMap<String, String>> seeCourses(String username) {
        String id = UC.UsernameToID(username);
        return CC.seeCourses(id);
    }

    public List<HashMap<String,String>> seeQuestionsOfCourse(String coursename) {
        String id = CC.CoursenameToID(coursename);
        return QC.QuestionsOfCourse(id);
    }

    public void DeleteQuestion(String question) {
        QC.DeleteQuestion(question);

    }
}




