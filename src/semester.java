import java.util.LinkedList;
import java.util.List;

public class semester
{
    int year;
    String season;

    LinkedList<course> courses;
    LinkedList <Test> tests;

    public List<course> getAllCourses(){
        List<course> c = new LinkedList<course>();
        return c;
    }
}
