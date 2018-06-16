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

    public course CoursesInCharge(user username) {
        return model.CoursesInCharge(username);
    }

    public List<questions> seeQuestionsOfCourse(course course) {
        return model.seeQuestionsOfCourse(course);
    }

    public void DeleteQuestion(List<questions> qList,int question) {
        model.DeleteQuestion(qList.get(question).body);
    }

    public course CoursesInCrew(user user) {
        return model.CoursesInCrew(user);

    }

    public void AddNoteToQuestion(List<questions> qList, int i,String note) {
        model.AddNoteToQuestion(qList.get(i),note);
    }

    public void WriteSyllabus(course courseInCharge,String s) {
        model.WriteSyllabus(courseInCharge,s);
    }

    public void WriteQuestion(course courseInCrew,String body) {
        model.WriteQuestion(courseInCrew,body);
    }
}
