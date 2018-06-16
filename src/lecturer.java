public class lecturer extends CourseStaff {
    int Experiece;
    String Degree;

    public lecturer(String lastName, String firstName, String userName, String adress, String phone, String email, String password, String ID) {
        super(lastName, firstName, userName, adress, phone, email, password, ID);
        this.Experiece = 0;
        this.Degree = "First";
    }

    public void removeQuestion (){}
   public void testCrud (int moed){}


}
