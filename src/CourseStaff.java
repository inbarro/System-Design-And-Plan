public class CourseStaff extends user{


    public CourseStaff(String lastName, String firstName, String userName, String adress, String phone, String email, String password, String ID) {
        super(lastName, firstName, userName, adress, phone, email, password, ID);
    }

    public void CallStudents(){}
    public void createSlides(){}
    public void writeQuestion(){}
    public boolean isAbleToUpdate (int questionID){return false;}
    public void updateQuestion (){}
    public void saveQuesrionToDB (int questionID, int bankID){}
    public void deleteQuestionDB (int questionID){}
    public void deleteFromDB (String item, String type){}
    public void saveToDB (String item, String type){}
}
