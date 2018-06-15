import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;


public class Main  {
    public static void main (String[]args) throws Exception {
        System.out.println("hello there");
        UserCharger UC = UserCharger.getInstance();
        CourseCharger CC = CourseCharger.getInstance();
        QuestionCharger QC = QuestionCharger.getInstance();
        DBUtils DB = DBUtils.getInstance();
        List<HashMap<String,Object>> list = DBUtils.executeQuery("select * from users;");

    }
}
