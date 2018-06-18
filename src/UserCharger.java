import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Noy on 5/20/2018.
 */
public class UserCharger implements Charger {
    private static UserCharger userChargerInstance = null;
    List<user> users;

    private UserCharger()
    {
        users = new ArrayList<>();
        DBUtils.getInstance();
        List<HashMap<String, String>> result = DBUtils.executeQuery(String.format("select * from users;"));
        for(int i = 0 ; i<result.size();i++)
        {
            List<HashMap<String, String>> result1 = DBUtils.executeQuery(String.format("select * from roles where userID ='%s';",result.get(i).get("id")));
            String role = result1.get(0).get("role");
                if(role.equals("CourseManager"))
                    users.add(new CourseManager(result.get(i).get("last_name"), result.get(i).get("first_name"), result.get(i).get("user_name"), result.get(i).get("address"), result.get(i).get("phone"), result.get(i).get("email"), result.get(i).get("password"), result.get(i).get("id")));
                if(role.equals("Student"))
                    users.add(new student(result.get(i).get("last_name"), result.get(i).get("first_name"), result.get(i).get("user_name"), result.get(i).get("address"), result.get(i).get("phone"), result.get(i).get("email"), result.get(i).get("password"), result.get(i).get("id")));
                if(role.equals("tutor"))
                    users.add(new tutor(result.get(i).get("last_name"), result.get(i).get("first_name"), result.get(i).get("user_name"), result.get(i).get("address"), result.get(i).get("phone"), result.get(i).get("email"), result.get(i).get("password"), result.get(i).get("id")));

        }

        System.out.println("Building UserCharger for the first time...");
    }

    public static UserCharger getInstance()
    {
        if (userChargerInstance == null)
            userChargerInstance = new UserCharger();

        return userChargerInstance;
    }

    public void register (String params){}
    public List<user> getAllUsers (){
        List <user> u = new LinkedList<>();
        return u;
    }
    public void enterIDFromUser (int userID){}
    public void updateDetails(int userID, String newInfo){}


    public String UsernameToID(String username){
        List<HashMap<String, String>> a = DBUtils.executeQuery(String.format(String.format("Select * from users where user_name = '%s'; ",username)));
        String id =  a.get(0).get("id");
        return id;
    }

    public user Login(String username, String password) {
        user TempUser = null;

        for(int i =0; i<users.size();i++)
            if(users.get(i).UserName.equals(username) && users.get(i).Password.equals(password))
                TempUser = users.get(i);

        return TempUser;
    }
}
