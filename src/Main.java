import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import static javafx.application.Application.launch;


public class Main extends Application{

    public static void main (String[]args) throws Exception
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Starting the app...");
        Controller c = new Controller();
        View v= new View();
        Model m = new Model();
        m.SetController(c);
        c.setModel(m);
        c.setView(v);
        v.setController(c);
        v.Start(primaryStage);
    }
}
