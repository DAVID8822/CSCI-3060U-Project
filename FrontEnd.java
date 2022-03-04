import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class FrontEnd {
    public static void login(){
        
    }
    public static void logout(){
        
    }

    public static void create() throws IOException{
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        String name;
        String password;
        String userType;
        System.out.println("Please enter a username");
        name = reader.readLine();
        System.out.println("Please enter a password");
        password = reader.readLine();
        System.out.println("Please enter a user type");
        userType = reader.readLine();
        
        try {
            FileWriter myWriter = new FileWriter("dailyTransactions.txt");
            myWriter.write("A New " + userType + " user by the name of " + name + "was created. The password is " + password);
            myWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }

          
    }

    public static void delete(){

    }
    public static void post(){
        
    }
    public static void rent(){
        
    }
    public static void search(){
        
    }
    
    

    public static void main(String[] args) throws IOException {
 


    }

  

  
}

