public class User{//This is a user account object
//Variables defining the user account object
public String name;
public String password;
public String userType;

//Constructor
public User(String newname, String newPassword, String type){
    this.name = newname;
    this.password = newPassword;
    this.userType = type;

}

//Returns the user's account name
public String getUser(){
    return name;
}
//Returns the user's password
public String getPassword(){
    return password;
}
//Returns the user's type of account 
public String getUserType(){
    return userType;
}

}