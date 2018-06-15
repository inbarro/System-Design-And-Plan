import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class course {
    String name, info, sylabus;
    int ID;
    questionBank questionBank;
    LinkedList<semester> semesters;
    Department department;
    LinkedList<CourseStaff> courseStaffs;
    LinkedList<CourseStaffStatus> courseStaffStatus;
    LinkedList<EducationAssistant> educationAssistants;
    LinkedList<Test> tests;

    public boolean isDateHasSet(int moed) {
        return false;
    }

    public List<questions> getAllQuestions() {
        List<questions> q = new ArrayList<>();
        return q;
    }

    public void confirmExam (int examID){}
    public void addSyllabus (String sylabus){}
    public String getSyllabus (){
        return "";
    }

    public List <Test> getWaitingExams(){
        List <Test> t = new ArrayList<>();
        return t;
    }
}