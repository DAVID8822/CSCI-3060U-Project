import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class FrontEnd {
    //Map to store user's account
    public static Map<String, User> accountMap = new HashMap<>();
    public static ArrayList<Post> rentalList = new ArrayList<>();
    public static User currentUser = null;

    //Login method to process user into the system
    public static void login() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String username;
        String password;

        System.out.println("Please enter your username");
        username = reader.readLine();

        System.out.println("Please enter your password");
        password = reader.readLine();
        
        //Validates user's account
        if (accountMap.containsKey(username)){
            System.out.println("Inputted password is " + password);
            System.out.println("Actual password is " + accountMap.get(username).getPassword());
            if(accountMap.get(username).getPassword().equals(password)){
                System.out.println("LOGIN SUCCESS! Welcome to OT-BnB " + username);
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

    //Logout method to process users our of the system
    public static void logout() throws IOException{
        //Placeholder variables
        Integer code = 0;
        Integer bedrooms = 0;
        Integer nights = 0;
        String username = "";
        String type ="";
        String rentalUnit="";
        String city= "";
        Double price = 0.0;
        Boolean loggedIn = true;
        
        //Checks to see if there is a user logged into the system currently
        if(loggedIn == true)
        {
            System.out.println("You have successfully logged out.");
            
            //Print's daily transaction file after logging out.
            try (BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransaction.txt", true))) {
                fw.write(code+" "+username+" "+type+" "+rentalUnit+" "+city+" "+bedrooms+" "+price+" "+nights);
                currentUser = null;
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("No user is currently logged in.");
        }
        
    }

    //Create method to create a new user onto the system
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

        //Stores newly created user into map
        accountMap.put(name, new User(name, password, userType));
        //Creates a text daily transaction file with the new user's information.
        try {

            BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransactions.txt", true));
            fw.write("A New " + userType + " user by the name of " + name + " was created. The password is " + password);
            fw.newLine();
            fw.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
     
    }

    //Delete method to delete a user's account from the system.
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

    //Post
    //This method reads the users inputs for the listing up on the site
    public static void post() throws NumberFormatException, IOException{
            String cityName;
            int id;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter an id (Numbers only");
            id = Integer.parseInt(reader.readLine());
            System.out.println("Please enter the name of the city; ");
            cityName = reader.readLine();

            double rentalPrice;
            System.out.println("Please enter the price of the unit: ");
            rentalPrice = Double.parseDouble(reader.readLine());

            int numbedrooms;
            System.out.println("Please enter the bedroom count: ");
            numbedrooms = Integer.parseInt(reader.readLine());
            rentalList.add(new Post(cityName, rentalPrice, numbedrooms,false, id));

            //Generates daily transaction file with posted listing
            BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransactions.txt", true));
            fw.write("A New posting in " + cityName + " with a rent of " + rentalPrice + " was created. The number of bedrooms is " + numbedrooms);
            fw.newLine();
            fw.close();
             
    }

    //Rent method to all users to rent listings
    public static void rent() throws NumberFormatException, IOException{
        int id;
        int nights;
        Post rentedPosting = null;
        double totalcost;
        String choice;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter an id (Numbers only");
        id = Integer.parseInt(reader.readLine());

        System.out.println("Please enter the name of the city; ");
        nights = Integer.parseInt(reader.readLine());
        
        //Gets a rental listing with id
        for (Post x: rentalList){
            if (x.getID() == id){
                rentedPosting = x;
            }
        }

        totalcost = rentedPosting.getrentalPrice() * nights;
        System.out.println("The rent per night is " + rentedPosting.getrentalPrice() + " and the total cost is " + totalcost  + " Rent? YES/NO");

        //Ask for confirmation of rental
        choice = reader.readLine();
        if (choice.equals("YES")){
            System.out.println("Rental successful");
        rentedPosting.setRented(true);
        }
        else if (choice.equals("NO")){
            System.out.println("Rental cancelled");
        }

        //Writing to transaction file
        BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransactions.txt", true));
        fw.write("Rental id" + id + " was rented for " + nights + " nights with a total cost of " + totalcost + ".");
        fw.newLine();
        fw.close();

        
    }

    //Search
    //This method finds the units by city based on the users input. 
    public static void search() throws NumberFormatException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cityName;
        double maxRentalPrice;
        int minBedrooms;

        //An array that stores a filtered list of search
        ArrayList<Post> returnedSearch = new ArrayList<>();
        System.out.println("Please enter a city to search");
        cityName = reader.readLine();
        System.out.println("Please enter a max rental price");
        maxRentalPrice = Double.parseDouble(reader.readLine());
        System.out.println("Please enter the minimum bedrooms");
        minBedrooms = Integer.parseInt(reader.readLine());

        //Filters listing to add to the array
        for (Post currPost: rentalList){
            if (currPost.getCityName().equals(cityName) && currPost.getrentalPrice() <= maxRentalPrice && currPost.getNumBedrooms()>=minBedrooms){
                returnedSearch.add(currPost);
            }
        }
        System.out.println("Found postings");
        for (Post x: returnedSearch){
            System.out.println("City name " + x.getCityName());
            System.out.println("Rental price " + x.getrentalPrice());
            System.out.println("Number of bedrooms " + x.getNumBedrooms());
            System.out.println("ID:" + x.getID());
        }

        //Generates daily transaction regarding a search
        BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransactions.txt", true));
        fw.write("A search was for postings in " + cityName + " with a max rent of " + maxRentalPrice + "  And a min number of bedrooms is " + minBedrooms + "was conducted.");
        fw.newLine();
        fw.close();

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        String choice;

        //Menu options
        do{
            System.out.println("Welcome to OT-BnB");
            System.out.println("Please enter option");
            choice = reader.readLine();
            if (choice.equals("create")){
                create();
            }
            else if (choice.equals("delete") && currentUser != null){
                delete();
            }
            else if (choice.equals("login") ){
                login();
            }
            else if (choice.equals("logout")){
                logout();
            }
            else if (choice.equals ("post")&& currentUser != null){
                post();
            }
            else if (choice.equals ("search")&& currentUser != null){
                search();
            }
            else if(choice.equals("test")){
                System.out.println("Accountmap" + accountMap);
                System.out.println("RentalList" + rentalList);
                System.out.println("CurrentUser" + currentUser);
            }

            else{
                System.out.println("Invalid choice");
            }
          
        }while(!choice.equals("exit")); //exit exits program

    }

  

  
}
