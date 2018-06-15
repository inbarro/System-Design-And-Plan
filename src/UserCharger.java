import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Noy on 5/20/2018.
 */
public class UserCharger implements Charger {
    private static UserCharger userChargerInstance = null;

    private UserCharger()
    {

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

    @Override
    public void saveToDB(String type, Object o) {

    }

    @Override
    public void deleteFromDB(String type, int ID) {

    }

    @Override
    public void updateDB(String type, int id, Object New) {

    }

    public String UsernameToID(String username){
        List<HashMap<String, String>> a = DBUtils.executeQuery(String.format(String.format("Select * from users where user_name = '%s'; ",username)));
        String id =  a.get(0).get("id");
        return id;
    }

    public boolean Login(String username, String password) {
        DBUtils.getInstance();
        List<HashMap<String, String>> result = DBUtils.executeQuery(String.format("select * from users where user_name = '%s' and password = '%s'; ",username,password));
        return result.size()>0;
    }
}
