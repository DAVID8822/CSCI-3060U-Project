import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
public class FrontEnd {
    public static Map<String, User> accountMap = new HashMap<>();
    public static Map<String, Post> rentalMap = new HashMap<>();
    public static User currentUser = null;
    public static void login() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String username;
        String password;

        System.out.println("Please enter your username");
        username = reader.readLine();

        System.out.println("Please enter your password");
        password = reader.readLine();
        
        if (accountMap.containsKey(username)){
            if(accountMap.get(username).getPassword() == password){
                System.out.println("Welcome to OT-BnB " +username);
                currentUser = accountMap.get(username);
            }
            else{
                System.out.println("Invalid password");
            }
        }
        else{
            System.out.println("User does not exist");
        }
    }
    public static void logout() throws IOException{
        Integer code = 0;
        Integer bedrooms = 0;
        Integer nights = 0;
        String username = "";
        String type ="";
        String rentalUnit="";
        String city= "";
        Double price = 0.0;
    
        System.out.println("You have successfully logged out.");
       
            try (BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransaction.txt", true))) {
                fw.write(code+" "+username+" "+type+" "+rentalUnit+" "+city+" "+bedrooms+" "+price+" "+nights);
                currentUser = null;
            }
        
        catch(IOException e){
            e.printStackTrace();
        }
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

    }

    public static void post() throws NumberFormatException, IOException{
            String cityName;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter the name of the city; ");
            cityName = reader.readLine();
            
            double rentalPrice;
            System.out.println("Please enter the price of the unit: ");
            rentalPrice = Double.parseDouble(reader.readLine());

            int numbedrooms;
            System.out.println("Please enter the bedroom count: ");
            numbedrooms = Integer.parseInt(reader.readLine());
            rentalMap.put(cityName, new Post(cityName, rentalPrice, numbedrooms,false));

            try {
                BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransactions.txt", true));
                fw.write("A New posting in " + cityName + " with a rent of " + rentalPrice + " was created. The number of bedrooms is " + numbedrooms);
                fw.newLine();
                fw.close();
              } catch (IOException e) {
                e.printStackTrace();
              }
    }
    public static void rent(){
        
    }
    public static void search(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cityName;
        double maxRentalPrice;
        int minBedrooms;
        System.out.println("Please enter a city to search");
        cityName = reader.readLine();
        System.out.println("Please enter a city to search");
        maxRentalPrice = Double.parseDouble(reader.readLine());
        System.out.println("Please enter a city to search");
        minBedrooms = Integer.parseInt(reader.readLine());

        //passes the city name to search
        if (Search(cityName) == 0 || Search(cityName) == null){
            System.out.println("Nothing found for " + cityName);
        }else{
            System.out.println("Nothing found for " + Search(cityName));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        String choice;
        do{
            System.out.println("Welcome to OT-BnB");
            System.out.println("Please enter option");
            choice = reader.readLine();
            if (choice.equals("create")){
                create();
            }
            else if (choice.equals("delete")){
                delete();
            }
            else if (choice.equals("login")){
                login();
            }
            else if (choice.equals("logout")){
                logout();
            }
            else{
                System.out.println("Invalid choice");
            }
        }while(!choice.equals("exit"));

    }

  

  
}
