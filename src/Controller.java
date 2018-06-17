import java.util.List;

public class Controller {
    View View;
    Model model;



    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setView(View View) {
        this.View = View;
    }

    public user Login(String username, String password) {
        return model.Login(username,password);
    }

    public List<course> CoursesInCharge(user username) {
        return model.CoursesInCharge(username);
    }

    public List<questions> seeQuestionsOfCourse(course course) {
        return model.seeQuestionsOfCourse(course);
    }

    public void DeleteQuestion(questions question) {
        model.DeleteQuestion(question.body);
    }

    public List<course> CoursesInCrew(user user) {
        return model.CoursesInCrew(user);

    }

    public void AddNoteToQuestion(questions q,String note) {
        model.AddNoteToQuestion(q,note);
    }

    public void WriteSyllabus(course courseInCharge,String s) {
        model.WriteSyllabus(courseInCharge,s);
    }

    public void WriteQuestion(course courseInCrew,String body) {
        model.WriteQuestion(courseInCrew,body);
    }
}
