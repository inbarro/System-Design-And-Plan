import java.util.List;

public class Model {
    UserCharger UC;
    CourseCharger CC;
    QuestionCharger QC;
    Controller c;
    user LoggedUser;

    public Model() {
         UC = UserCharger.getInstance();
         CC = CourseCharger.getInstance();
         QC = QuestionCharger.getInstance();
    }


    public void SetController(Controller c) {
        this.c = c;
    }

    public user Login(String username, String password) {
        LoggedUser = UC.Login(username,password);
        return LoggedUser;
    }



    public List<questions> seeQuestionsOfCourse(course course) {
        questionBank maagar = QC.getMaagar(course);
        CC.setMaagar(course,maagar);
        return QC.QuestionsOfCourse(maagar);
    }

    public void DeleteQuestion(String question) {
        QC.DeleteQuestion(question);

    }

    public List<course> CoursesInCharge(user username) {
        return CC.CoursesInCharge(username.ID);
    }

    public List<course> CoursesInCrew(user user) {
        return CC.CoursesInCrew(user.ID);

    }

    public void AddNoteToQuestion(questions question,String note) {
        QC.AddNoteToQuestion(question,note,LoggedUser);
    }

    public void WriteSyllabus(course courseInCharge,String s) {
        CC.WriteSyllabus(courseInCharge,s);
    }

    public void WriteQuestion(course courseInCrew,String body) {
        QC.WriteQuestion(courseInCrew,body,LoggedUser.UserName);
    }
}




