import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
public class FrontEnd {
    public static Map<String, User> accountMap = new HashMap<>();
    public static void login(){
        
    }
    public static void logout(){
        
    }

    public static void create() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String name;
        String password;
        String userType;
        System.out.println("Please enter a username");
        name = reader.readLine();
        System.out.println("Please enter a password");
        password = reader.readLine();
        System.out.println("Please enter a user type");
        userType = reader.readLine();
        accountMap.put(name, new User(name, password, userType));
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransactions.txt", true));
            fw.write("A New " + userType + " user by the name of " + name + " was created. The password is " + password);
            fw.newLine();
            fw.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        System.out.println(accountMap);
          
    }

    public static void delete() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String usertoDelete;
        System.out.println("Please enter a username");
        usertoDelete = reader.readLine();
        accountMap.remove(usertoDelete);
        BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransactions.txt", true));
        fw.write("User " + usertoDelete +  " was deleted");
        fw.newLine();
        fw.close();
        System.out.println(accountMap);
    }

    public static void post(){
        
    }
    public static void rent(){
        
    }
    public static void search(){
        
    }
    
    

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        String choice;
        do{
            System.out.println("Please enter option");
            choice = reader.readLine();
            if (choice.equals("create")){
                create();
            }
            else if (choice.equals("delete")){
                delete();
            }
        }while(!choice.equals("exit"));

    }

  

  
}

