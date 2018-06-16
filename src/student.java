public class student extends user {
   double AverageGrade;


   public student(String lastName, String firstName, String userName, String adress, String phone, String email, String password, String ID) {
      super(lastName, firstName, userName, adress, phone, email, password, ID);
      this.AverageGrade = 0;
   }
}
