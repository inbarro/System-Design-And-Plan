public class Controller implements Observer {
    CourseCharger CourseModel;
    QuestionCharger QuestionModel;
    UserCharger UserModel;
    View View;

    public Controller(CourseCharger courseModel, QuestionCharger questionModel, UserCharger userModel, View view) {
        CourseModel = courseModel;
        QuestionModel = questionModel;
        UserModel = userModel;
        View = view;
    }


    @Override
    public void update() {
    //Updating the view
    }
}
