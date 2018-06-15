import java.util.HashMap;
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

    public boolean Login(String username, String password) {
        return model.Login(username,password);
    }

    public List<HashMap<String, String>> seeCourses(String username) {
        return model.seeCourses(username);
    }

    public List<HashMap<String,String>> seeQuestionsOfCourse(String coursename) {
        return model.seeQuestionsOfCourse(coursename);
    }

    public void DeleteQuestion(String question) {
        model.DeleteQuestion(question);
    }
}
