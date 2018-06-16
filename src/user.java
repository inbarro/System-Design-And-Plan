public class user {
    String ID,LastName,FirstName,UserName,Adress,Phone,Email,Password;



    public user()
    {}

    public user(String lastName, String firstName, String userName, String adress, String phone, String email, String password, String ID) {
        LastName = lastName;
        FirstName = firstName;
        UserName = userName;
        Adress = adress;
        Phone = phone;
        Email = email;
        Password = password;
        this.ID = ID;
    }

    public boolean logIn (String userName, String password) {
        return false;
    }

    public boolean UpdateDetails(String adress,String phone,String Email,String password){
        return false;
    }
}
