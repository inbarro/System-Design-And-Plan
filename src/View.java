import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class View {
    public static final String ANSI_RED = "\033[1;31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static Scanner reader = new Scanner(System.in);


    Controller c;
    public void Start() {

        PrintColor("Please enter your User and password");
        String username = reader.nextLine(); // Scans the next token of the input as an int.
        String Password = reader.nextLine();
        PrintColor(String.format("You have entered %s and %s",username,Password));
        user user = c.Login(username,Password);
        if(user!=null) {
            PrintColor("Welcome " + username);
            course courseInCharge = c.CoursesInCharge(user);
            course courseInCrew = c.CoursesInCrew(user);

            if (courseInCharge!=null)
                System.out.println("You are in charge of " +courseInCharge.name);
            if (courseInCrew!=null)
                System.out.println("You are in crew of " +courseInCrew.name);

            int option = PrintOptions();

            if(option==1)
                DeleteQuestionOption(courseInCharge);
            if(option==2)
                WriteNoteForQuestion(courseInCrew);
            if(option==3)
                WriteSyllabus(courseInCharge);
            if(option==4)
                WriteQuestion(courseInCrew);

        }
        reader.close();
    }

    private void WriteQuestion(course courseInCrew) {
        PrintColor("Here are the current course questions");
        List<questions> qList = c.seeQuestionsOfCourse(courseInCrew);
        PrintQuestions(qList);
        System.out.println("Please enter the question -");
        reader.nextLine();
        String body = reader.nextLine();
        c.WriteQuestion(courseInCrew,body);


    }

    private void WriteSyllabus(course courseInCharge) {
        PrintColor("Please Enter the Syallbus");
        reader.nextLine();
        String syllabus = reader.nextLine();
        c.WriteSyllabus(courseInCharge,syllabus);
    }

    private void WriteNoteForQuestion(course courseInCrew) {
        PrintColor("You can add notes for questions from the course " + courseInCrew.name);
        List<questions> qList = c.seeQuestionsOfCourse(courseInCrew);
        if (qList.size() > 0) {
            PrintQuestions(qList);
            PrintColor("Please enter a Question index to add note");
            int question = reader.nextInt();
            System.out.println("Please enter the note");
            reader.nextLine();
            String note = reader.nextLine();
            c.AddNoteToQuestion(qList, question - 1,note);
        } else {
            System.out.print("There are no questions");
        }

    }


    public void DeleteQuestionOption(course courseInCharge)
    {
        PrintColor("You can delete questions from the course " + courseInCharge.name);
        List<questions> qList = c.seeQuestionsOfCourse(courseInCharge);
        if (qList.size() > 0) {
            PrintQuestions(qList);
            PrintColor("Please enter a Question index to remove");
            int question = reader.nextInt();
            c.DeleteQuestion(qList, question - 1);
        } else {
            System.out.print("There are no questions");
        }
    }
    private int PrintOptions() {
        PrintColor("Please choose your option -");
        PrintColor("1. Delete question from course you are in charge");
        PrintColor("2. Write note for question of course you are a crew");
        PrintColor("3. Write syllabus of course you are in charge");
        PrintColor("4. Write question for course you are a crew");


        int option = reader.nextInt();

        return option;




    }

    private void PrintCourses(List<course> courses) {
        for(int i =0;i<courses.size();i++)
            System.out.println((i+1) + ". " + courses.get(i).name);

    }

    private void PrintColor(String s) {
        System.out.println(ANSI_RED + s + ANSI_RESET);

    }

    private void PrintQuestions(List<questions> list) {
        for(int i = 0 ; i<list.size() ; i++)
        {
            PrintColor((i+1) + ". " + list.get(i).body);
        }
    }

    public void setController(Controller c) {
        this.c = c;
    }
}
