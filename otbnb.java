/*Welcome to OT-BNB
//Description: This program is the front end of an application that keeps track of different rental properties much like the real Air-BNB. 
It supports the creation and deletion of accounts, logging in and out as well as searching for and renting a property functionalities.

Input: The program takes input from 2 files. An available rental units file consisting of properties and a current user accounts file consisting
of users within the system.

Output: The program's output is the daily transactions text file which keeps track of every action that occurs within the system across all users

How to run: The program is intended to be run from a terminal. Run the java file through the terminal and you will be prompted with a menu of options,
type in the name of the action you wish to complete and you will be guided through further prompts on the screen. When you wish you exit the program, 
type exit at the main menu.
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class otbnb {
    //Map to store user's account
    public static Map<String, User> accountMap = new HashMap<>();
    //Array list to store rental listings
    public static ArrayList<Post> rentalList = new ArrayList<>();
    //Keeps track of the current logged in user
    public static User currentUser = null;

    //Login method
    //Processes user into the system with their given username and password
    public static void login() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String username;
        String password;

        //Ask user for username
        System.out.println("Please enter your username");
        username = reader.readLine();

        //Ask user for password
        System.out.println("Please enter your password");
        password = reader.readLine();
        
        //Validates user's account
        //Checks if username and password matches in the accountMap then processes login accordingly
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

    //Logout method
    //Processes user out of the system
    public static void logout() throws IOException{
        Integer code = 0;
        Integer bedrooms = 0;
        Integer nights = 0;
        String username = "";
        String type ="";
        String rentalUnit="";
        String city= "";
        Double price = 0.0;
        Boolean loggedIn = false;
        
        //Checks to see if there is a user logged into the system currently
        if(loggedIn == true)
        {
            System.out.println("You have successfully logged out.");
            loggedIn = false;
            //Print's daily transaction file after logging out.
            try (BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransaction.txt", true))) {
                //fw.write(code+" "+username+" "+type+" "+rentalUnit+" "+city+" "+bedrooms+" "+price+" "+nights);
                fw.write(currentUser + " Has logged out");
                fw.newLine();
                fw.close();
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

    //Create method
    //Create a new user onto the system with the user's given credential
    public static void create() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        String name;
        String password;
        String userType;

        //Ask user for username
        System.out.println("Please enter a username");
        name = reader.readLine();

        //Ask user for password
        System.out.println("Please enter a password");
        password = reader.readLine();

        //Ask user for account type
        System.out.println("Please enter a user type");
        userType = reader.readLine();

        //Stores newly created user into map
        accountMap.put(name, new User(name, password, userType));
        //Creates a text file with the new user's information
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransactions.txt", true));
            fw.write("A New " + userType + " user by the name of " + name + " was created. The password is " + password);
            fw.newLine();
            fw.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
     
    }

    //Delete method
    //Delete a user's account from the system based on the username provided
    public static void delete() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String usertoDelete;

        //Ask for username to be deleted
        System.out.println("Please enter a username");
        usertoDelete = reader.readLine();

        //Deletes user from system
        accountMap.remove(usertoDelete);

        //Writes a file regarding the deleted user
        BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransactions.txt", true));
        fw.write("User " + usertoDelete +  " was deleted");
        fw.newLine();
        fw.close();

    }

    //Post method
    //Reads the users inputs for the listing up on the site
    public static void post() throws NumberFormatException, IOException{
            String cityName;
            int id;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            //Ask user for an id for post
            System.out.println("Please enter an id (Numbers only");
            id = Integer.parseInt(reader.readLine());
            
            //Ask user for the name of the city
            System.out.println("Please enter the name of the city; ");
            cityName = reader.readLine();

            //Ask user for price of rental unit
            double rentalPrice;
            System.out.println("Please enter the price of the unit: ");
            rentalPrice = Double.parseDouble(reader.readLine());

            //Ask user for amount of bedrooms in unit
            int numbedrooms;
            System.out.println("Please enter the bedroom count: ");
            numbedrooms = Integer.parseInt(reader.readLine());

            //Post the rental unit to the array.
            rentalList.add(new Post(cityName, rentalPrice, numbedrooms,false, id));

            //Generates daily transaction file with posted listing
            BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransactions.txt", true));
            fw.write("A New posting in " + cityName + " with a rent of " + rentalPrice + " was created. The number of bedrooms is " + numbedrooms);
            fw.newLine();
            fw.close();
             
    }

    //Rent method
    //User rents a unit based on the id and city given
    public static void rent() throws NumberFormatException, IOException{
        int id;
        int nights;
        Post rentedPosting = null;
        double totalcost;
        String choice;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Ask user for id of the rental unit
        System.out.println("Please enter an id (Numbers only");
        id = Integer.parseInt(reader.readLine());

        //Ask user for the city
        System.out.println("Please enter the name of the city; ");
        nights = Integer.parseInt(reader.readLine());
        
        //Gets the rental unit based on id
        for (Post x: rentalList){
            if (x.getID() == id){
                rentedPosting = x;
            }
        }

        //Calculate cost of rental unit
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

        //Write a transaction file on rent made
        BufferedWriter fw = new BufferedWriter(new FileWriter("dailyTransactions.txt", true));
        fw.write("Rental id" + id + " was rented for " + nights + " nights with a total cost of " + totalcost + ".");
        fw.newLine();
        fw.close();

        
    }
    //Search method
    //Finds the units by city based on the users input. 
    public static void search() throws NumberFormatException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cityName;
        double maxRentalPrice;
        int minBedrooms;

        //An array that stores a filtered list of search
        ArrayList<Post> returnedSearch = new ArrayList<>();

        //Ask user for a city
        System.out.println("Please enter a city to search");
        cityName = reader.readLine();

        //Ask user for max rental price
        System.out.println("Please enter a max rental price");
        maxRentalPrice = Double.parseDouble(reader.readLine());

        //Ask user for minimum amount of bedrooms
        System.out.println("Please enter the minimum bedrooms");
        minBedrooms = Integer.parseInt(reader.readLine());

        //Filters listing to add to the array
        for (Post currPost: rentalList){
            if (currPost.getCityName().equals(cityName) && currPost.getrentalPrice() <= maxRentalPrice && currPost.getNumBedrooms()>=minBedrooms){
                returnedSearch.add(currPost);
            }
        }
        //Feedback to user on the list of rental units found in search
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
    public static String[] readFile(String filename) throws IOException{
        String [] commands = new String [100];
        String line;
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while ((line = reader.readLine()) != null){
            commands[count] = line;
            count++;
        }
        reader.close();
        return commands;  
    }
    //Main program
    //The start of the program, when users run it they will be prompted with a menu to select an option
    //Based on the given input it will process the command and run the appropriate method
    public static void main(String[] args) throws IOException {
        //TODO LATER: Implement the inputs to work (Use an array to store every transaction input)
        //Read in inputs from input files
        //Make output only for each user upon logout
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        String choice;
        //Menu options
        //To Run, do java otbnb.java rentals.txt users.txt dailyTransactions.txt in a terminal
        String[] userFile =readFile(args[0]); 
        String[] rentalFile=readFile(args[1]);
        String[] transFile= readFile(args[2]);

        do{
            System.out.println("Welcome to OT-BnB");
            System.out.println("Please enter option");
            System.out.println("create, delete, login, logout, post, search");
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
                System.out.println("Choices are: create, delete, login, logout, post, search");
            }
          
        }while(!choice.equals("exit")); //exit exits program
    
    }

  

  
}
