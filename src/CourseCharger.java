import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Noy on 5/20/2018.
 */
public class CourseCharger implements Charger   {
    private static CourseCharger courseChargerInstance = null;
    List<course> courses;


    private CourseCharger()
    {
        courses = new ArrayList<>();
        List<HashMap<String, String>> result = DBUtils.executeQuery(String.format("select * from course;"));
        for(int i =0 ; i<result.size();i++)
            courses.add(new course(result.get(i).get("name"),result.get(i).get("ProfessorID"),result.get(i).get("Sylbaus"),result.get(i).get("crew"),result.get(i).get("incharge"),result.get(i).get("id")));
        System.out.println("Building CourseCharger for the first time...");
    }

    public static CourseCharger getInstance()
    {
        if (courseChargerInstance == null)
            courseChargerInstance = new CourseCharger();

        return courseChargerInstance;
    }


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



    public course getCourse(String CourseID){
        for(int i = 0;i<courses.size();i++)
            if(courses.get(i).ID.equals(CourseID))
                return courses.get(i);

        return null;
    }

    public void setMaagar(course course, questionBank maagar) {
        for(int i = 0;i<courses.size();i++)
            if(courses.get(i).ID.equals(course.ID))
                courses.get(i).maagarID = maagar;
    }

    public List<course> CoursesInCharge(String id) {
        List<course> courseList=new ArrayList<>();
        for(int i =0;i<courses.size();i++)
            if(courses.get(i).incharge.equals(id))
                courseList.add(courses.get(i));

        return courseList;
    }

    public List<course> CoursesInCrew(String id) {
        List<course> courseList=new ArrayList<>();
        for(int i = 0;i<courses.size();i++)
            if(courses.get(i).crew.contains(id))
                courseList.add(courses.get(i));
        return courseList;
    }

    public void WriteSyllabus(course courseInCharge,String syllabus) {
        courseInCharge.sylabus = syllabus;
        DBUtils.executeQuery(String.format("Update course set Sylbaus = '%s' where id = '%s';",syllabus,courseInCharge.ID));
    }
}


