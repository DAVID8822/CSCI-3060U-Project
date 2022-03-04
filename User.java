public class User{
public String name;
public String password;
public String userType;
    
public User(String newname, String newPassword, String type){
    this.name = newname;
    this.password = newPassword;
    this.userType = type;
}

public String getUser(){
    return name;
}
public String getPassword(){
    return password;
}
public String getUserType(){
    return userType;
}
}