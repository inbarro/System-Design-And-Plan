import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;


public class Main  {
    public static void main (String[]args) throws Exception {
        System.out.println("Starting the app...");
        Controller c = new Controller();
        View v= new View();
        Model m = new Model();
        m.SetController(c);
        c.setModel(m);
        c.setView(v);
        v.setController(c);

        v.Start();

    }
}
