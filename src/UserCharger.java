import java.util.LinkedList;
import java.util.List;

/**
 * Created by Noy on 5/20/2018.
 */
public class UserCharger extends Observable implements Charger {
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
}
