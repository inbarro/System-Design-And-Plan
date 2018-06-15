import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class View {
    public static final String ANSI_RED = "\033[1;31m";
    public static final String ANSI_RESET = "\u001B[0m";


    Controller c;
    public void Start() {
        Scanner reader = new Scanner(System.in);
        PrintColor("Please enter your User and password");
        String username = reader.nextLine(); // Scans the next token of the input as an int.
        String Password = reader.nextLine();
        PrintColor(String.format("You have entered %s and %s",username,Password));
        if(c.Login(username,Password)) {
            PrintColor("Welcome " + username);
            PrintColor("Lets delete a question");
            PrintList(c.seeCourses(username),"name");
            PrintColor("Please enter Course to remove");
            String coursename = reader.nextLine();
            PrintColor(String.format("You have entered %s" ,coursename));
            PrintList(c.seeQuestionsOfCourse(coursename),"body");
            PrintColor("Please enter a Question to remove");
            String question = reader.nextLine();
            c.DeleteQuestion(question);

        }






        reader.close();
    }

    private void PrintColor(String s) {
        System.out.println(ANSI_RED + s + ANSI_RESET);

    }

    private void PrintList(List<HashMap<String,String>> hashMaps,String key) {
        for(int i = 0 ; i<hashMaps.size() ; i++)
        {
            PrintColor((i+1) + ". " + hashMaps.get(i).get(key));
        }
    }

    public void setController(Controller c) {
        this.c = c;
    }
}
