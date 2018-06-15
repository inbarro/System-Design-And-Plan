public abstract class CourseStaff extends user{

    CourseStaff courseStaff;

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
