import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class View {
    public static final String ANSI_RED = "\033[1;31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static Scanner reader = new Scanner(System.in);
    Stage window;
    Controller c;
    String username;
    List<course> courseInCharge;
    List<course> courseInCrew;
    List<questions> qList;


    public void Start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Welcome ! ");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        Label welcomeLabel =new Label("Login here:");
        GridPane.setConstraints(welcomeLabel, 0, 0);
        Label usernameLabel = new Label("Enter user name:");
        GridPane.setConstraints(usernameLabel, 0, 1);
        Label passwordLabel = new Label("Enter password:");
        GridPane.setConstraints(passwordLabel, 0, 2);
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("user name here");
        GridPane.setConstraints(usernameInput, 1, 1);
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("password here");
        GridPane.setConstraints(passwordInput, 1, 2);
        Button loginbutton = new Button("login");
        GridPane.setConstraints(loginbutton, 2, 3);
        loginbutton.setOnAction(e->guiLogin(usernameInput.getText(),passwordInput.getText()));
        grid.getChildren().addAll(welcomeLabel, usernameLabel,passwordLabel,usernameInput,passwordInput,loginbutton);
        Scene scene = new Scene(grid, 500, 300);
        scene.getStylesheets().add("Style.css");
        window.setScene(scene);
        window.show();
    }

    private void WriteQuestion(String courseInCrewName)
    {
        if(courseInCrewName==null||courseInCrewName.equals(""))
        {
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Please choose a course from the courses you are in their crew");
            alert.show();
            return;
        }
        course cCrew=getCourseByName(courseInCrewName,courseInCrew);
        List<questions> qList = c.seeQuestionsOfCourse(cCrew);
        List<String> questionBody = new ArrayList<>();
        for(questions question : qList){
            questionBody.add(question.body);
        }
        ObservableList<String> olist= FXCollections.observableArrayList(questionBody);
        ListView<String> list2 = new ListView<>(olist);
        Stage questionWindow = new Stage();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        Label first =new Label("Mivhanet: questions");
        GridPane.setConstraints(first, 0, 0);
        Label currentQuestion =new Label("Here are the current course questions");
        GridPane.setConstraints(currentQuestion, 0, 1);
        GridPane.setConstraints(list2, 0, 2);
        Label insertQuestion =new Label("Please insert your new question here:");
        GridPane.setConstraints(insertQuestion, 0, 3);
        TextField questionInput= new TextField();
        questionInput.setPromptText("question...");
        GridPane.setConstraints(questionInput, 0, 4);
        Button submit = new Button("Submit question");
        GridPane.setConstraints(submit, 2, 5);
        submit.setOnAction(e->submitQuestion(cCrew,questionInput.getText(),questionInput));
        grid.getChildren().addAll(first,insertQuestion,questionInput,submit,list2);
        questionWindow.setTitle("Insert Question");
        questionWindow.setMinWidth(250);
        Scene scene = new Scene(grid, 500, 300);
        questionWindow.setScene(scene);
        questionWindow.show();
    }

    private void WriteSyllabus(String courseInChargeName) {
        if(courseInChargeName==null||courseInChargeName.equals(""))
        {
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Please choose a course from the courses you are in charge of them");
            alert.show();
            return;
        }
        course cCrew=getCourseByName(courseInChargeName,courseInCharge);
        Stage syllabusWindow = new Stage();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        Label first =new Label("Mivhanet: Syllabus");
        GridPane.setConstraints(first, 0, 0);
        Label insertSyllabus =new Label("Please insert your new syllabus here:");
        GridPane.setConstraints(insertSyllabus, 0, 1);
        TextField syllabusInput= new TextField();
        syllabusInput.setPromptText("syllabus...");
        GridPane.setConstraints(syllabusInput, 0, 2);
        Button submit = new Button("Submit syllabus");
        GridPane.setConstraints(submit, 2, 4);
        submit.setOnAction(e->submitSyllabus(cCrew,syllabusInput.getText(),syllabusInput));

        grid.getChildren().addAll(first,insertSyllabus,syllabusInput,submit);
        syllabusWindow.setTitle("Insert syllabus");
        syllabusWindow.setMinWidth(250);
        Scene scene = new Scene(grid, 500, 300);
        syllabusWindow.setScene(scene);
        syllabusWindow.show();
    }

    private void WriteNoteForQuestion(String courseName)
    {
        if(courseName==null||courseName.equals(""))
        {
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Please choose a course from the courses you are in their crew");
            alert.show();
            return;
        }
        Stage noteWindow = new Stage();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        course cCrew=getCourseByName(courseName,courseInCrew);
        qList = c.seeQuestionsOfCourse(cCrew);
        List<String> questionBody = new ArrayList<>();
        for(questions question : qList){
            questionBody.add(question.body);
        }
        ObservableList<String> olist= FXCollections.observableArrayList(questionBody);
        ComboBox<String> list2 = new ComboBox<>(olist);
        Label header= new Label("Please choose a Question to add a note to:");
        GridPane.setConstraints(header, 0, 0);
        GridPane.setConstraints(list2, 0, 1);
        TextField noteInput= new TextField();
        noteInput.setPromptText("note...");
        Label noteLabel= new Label("Please insert a note :");
        GridPane.setConstraints(noteLabel, 0, 3);
        GridPane.setConstraints(noteInput, 0, 4);
        Button submit = new Button("Submit note");
        GridPane.setConstraints(submit, 1, 5);
        submit.setOnAction(e->addNote(list2.getValue(),noteInput.getText(),noteInput));
        grid.getChildren().addAll(header, noteInput,submit,list2,noteLabel);
        noteWindow.setTitle("Notes");
        Scene scene = new Scene(grid, 500, 300);
        scene.getStylesheets().add("Style.css");
        noteWindow.setScene(scene);
        noteWindow.show();
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

    private void guiLogin(String uname,String password){
            if(uname==null ||uname.equals("")||password==null||password.equals(""))
            {
                Alert alert= new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error in login");
                alert.setContentText("The user name or password you entered is not correct\n please try again");
                alert.show();
            }
            else
            {
                user user= c.Login(uname,password);
                if(user!=null) {
                    courseInCharge = c.CoursesInCharge(user);
                    courseInCrew = c.CoursesInCrew(user);
                    username=uname;
                    loginView(courseInCharge,courseInCrew);
                }
                else
                {
                    Alert alert= new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Error");
                    alert.setContentText("Please enter a valid user name and password");
                    alert.show();
                }
            }
    }
    public void loginView(List<course> charge, List<course> crew){
        window.close();
        //VIEW LIST
        ComboBox<String> courseInCharge= toComboList(charge);
        ComboBox<String> courseInCrew= toComboList(crew);

        Stage mivanetwindow = new Stage();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        Label loggedLabel =new Label("Hello: "+username);
        GridPane.setConstraints(loggedLabel, 0, 0);
        Label courseincharegLabel=null;
        Label courseincrewLabel=null;
        if (charge!=null)
        {
            courseincharegLabel =new Label("You are in charge of:");
            GridPane.setConstraints(courseincharegLabel, 0, 1);
            GridPane.setConstraints(courseInCharge, 0, 2);
        }
        if (crew!=null)
        {
            courseincrewLabel=new Label("You are in crew of: ");
            GridPane.setConstraints(courseincrewLabel, 0, 3);
            GridPane.setConstraints(courseInCrew, 0, 4);
        }
        Button enterSylabus = new Button("Enter new syllabus");
        GridPane.setConstraints(enterSylabus, 2, 2);
        Button enterQuestion = new Button("Enter new question");
        GridPane.setConstraints(enterQuestion, 2, 4);
        Button addNoteQuestion = new Button("Add note to question");
        GridPane.setConstraints(addNoteQuestion, 3, 4);
        enterQuestion.setOnAction(e->WriteQuestion(courseInCrew.getValue()));
        addNoteQuestion.setOnAction(e->WriteNoteForQuestion(courseInCrew.getValue()));
        enterSylabus.setOnAction(e->WriteSyllabus(courseInCharge.getValue()));
        grid.getChildren().addAll(loggedLabel,courseincharegLabel,courseincrewLabel,enterSylabus,enterQuestion
                ,courseInCharge,courseInCrew,addNoteQuestion);

        mivanetwindow.setTitle("Mivhanet");
        mivanetwindow.setMinWidth(250);
        Scene scene = new Scene(grid, 500, 300);
        mivanetwindow.setScene(scene);
        mivanetwindow.show();
    }
    private void submitQuestion(course courseInCrew, String question, TextField t)
    {
        if(question!=null&&!(question.equals(""))) {
            c.WriteQuestion(courseInCrew, question);
            showAlert("question");
            Stage stage = (Stage) t.getScene().getWindow();
            stage.close();
        }
        else{
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a question");
            alert.show();
        }

    }
    private void submitSyllabus(course courseInCharge, String syllabus, TextField t)
    {
        if(syllabus!=null&&!(syllabus.equals(""))) {
            c.WriteSyllabus(courseInCharge,syllabus);
            showAlert("syllabus");
            Stage stage = (Stage) t.getScene().getWindow();
            stage.close();
        }
        else{
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Please enter a syllabus");
            alert.show();
        }

    }
    private void showAlert(String text){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Message");
        alert.setContentText("You enter the "+text+" successfully");
        alert.showAndWait();
    }
    private ComboBox<String> toComboList(List<course>courses){
        if(courses==null) {
            ComboBox<String> listview=new ComboBox<>();
            return listview;
        }
        List<String> result=new ArrayList<>();
        for(course course : courses){
            result.add(course.name);
        }
        ObservableList<String> olist= FXCollections.observableArrayList(result);
        ComboBox<String> listview = new ComboBox<>(olist);
        return listview;
    }

    private course getCourseByName(String name,List<course>courses){
        for(int i=0; i<courses.size();i++)
        {
            if(courses.get(i).name.equals(name))
                return courses.get(i);
        }
        return null;
    }
    private void addNote(String que, String note,TextField t)
    {
        questions questionAddNote=null;
        for(int i=0; i<qList.size();i++)
        {
            if(qList.get(i).body.equals(que))
                questionAddNote= qList.get(i);
        }
        if(questionAddNote==null||note.equals(""))
        {
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Please select a question and insert a valid note");
            alert.show();
            return;
        }

        c.AddNoteToQuestion(questionAddNote,note);
        showAlert("note");
        Stage stage = (Stage) t.getScene().getWindow();
        stage.close();


    }
}
