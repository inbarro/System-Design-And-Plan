import java.util.LinkedList;

public class questions {
    String WritenBy,body;
    int difficult,estimatedTime,id;
    LinkedList<choise> choises;
    LinkedList<note> notes;
    questionBank questionBank;
    LinkedList<Test> tests;
    LinkedList <QuestionInTest> questionInTests;

    public void noteCrude(){}
    public void optionCrude(){}
    public int culculateEstimateTime(){
        return estimatedTime ;
    }
    public questions getQuesion(questions questionID){
        questions q = new questions();
        return q ;
    }
    public questions getQuesionFromDB(questions questionID){
        questions q = new questions();
        return q ;
    }
    public void questionCrud(){}

}
