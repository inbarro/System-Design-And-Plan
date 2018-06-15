import java.util.LinkedList;
import java.util.List;

/**
 * Created by Noy on 5/20/2018.
 */
public class UserController extends Controller {
    private static UserController UserControllerInstance = null;

    private UserController()
    {

        System.out.println("Building UserController for the first time...");
    }

    public static UserController getInstance()
    {
        if (UserControllerInstance == null)
            UserControllerInstance = new UserController();

        return UserControllerInstance;
    }

    public void register (String params){}
    public List<user> getAllUsers (){
        List <user> u = new LinkedList<>();
        return u;
    }
    public void enterIDFromUser (int userID){}
    public void updateDetails(int userID, String newInfo){}
}
