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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;

public class otbnb {
    //Map to store user's account
    public static Map<String, User> accountMap = new HashMap<>();
    //Array list to store rental listings
    public static ArrayList<Post> rentalList = new ArrayList<>();
    //Keeps track of the current logged in user
    public static User currentUser = null;
    public static Boolean loggedIn = false;
    //Login method
    //Processes user into the system with their given username and password
    public static void login(BufferedReader reader) throws IOException{
        String username;
        String password;

        //Ask user for username
        System.out.println("Please enter your username");
        while((username = reader.readLine()).isEmpty()){
            System.out.println("Username cannot be empty try again");
        }

        //Ask user for password
        System.out.println("Please enter your password");
        while((password = reader.readLine()).isEmpty()){
            System.out.println("Password cannot be empty try again");
        }
        
        //Validates user's account
        //Checks if username and password matches in the accountMap then processes login accordingly
        if (accountMap.containsKey(username)){
            if(accountMap.get(username).getPassword().equals(password)){
                System.out.println("LOGIN SUCCESS! Welcome to OT-BnB " + username);
                loggedIn = true;
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
    public static void logout(String outputFile, ArrayList <String> storedOutput) throws IOException{
        
        
        //Checks to see if there is a user logged into the system currently
        if(loggedIn == true)
        {
            System.out.println("You have successfully logged out.");
            loggedIn = false;
            //Print's daily transaction file after logging out. 
                storedOutput.add("00" + "_" + currentUser.name + "_" + currentUser.userType + "_" + "00000000" + "_" + "000000000000000" + "_" + "0" + "_" + "000000" + "_"+ "00");
                writeFile(outputFile, storedOutput);
                currentUser = null;
      
        }
        else{
            System.out.println("No user is currently logged in.");
        }
        
    }

    //Create method
    //Create a new user onto the system with the user's given credential
    public static void create(BufferedReader reader, ArrayList <String> storedOutput) throws IOException{
        Set<String> accept = new HashSet<String>(Arrays.asList(new String[] {"AA", "FS", "BS", "SS"}));
        String name;
        String password;
        String userType;

        System.out.println("Please enter a username");
        while((name = reader.readLine()).isEmpty()){
            System.out.println("Username cannot be empty try again");
        }
    
        

        //Ask user for password
        System.out.println("Please enter a password");
        while((password = reader.readLine()).isEmpty()){
            System.out.println("Password cannot be empty try again");
        }

        //Ask user for account type
        System.out.println("Please enter a user type (AA-admin, FS-full standard, BS-buy standard, SS-sell-standard)");
        while(!accept.contains(userType = reader.readLine())){
            System.out.println("Invalid user type");
            System.out.println("Must be AA-admin, FS-full standard, BS-buy standard, SS-sell-standard");
        }

        //Stores newly created user into map
        accountMap.put(name, new User(name, password, userType));
 
        //Creates a text file with the new user's information
        storedOutput.add("01" + "_" + name + "_" + userType + "_" + "00000000" + "_" + "000000000000000" + "_" + "0" + "_" + "000000" + "_"+ "00");
     
    }
    public static void clear(String filename) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(filename);
        pw.close();
    }
    //Delete method
    //Delete a user's account from the system based on the username provided 
    public static void delete(BufferedReader reader, ArrayList <String> storedOutput) throws IOException{
        String usertoDelete;
        //Ask for username to be deleted
        System.out.println("Please enter a username");
        usertoDelete = reader.readLine();
        String userType = accountMap.get(usertoDelete).userType;
        //Deletes user from system
        accountMap.remove(usertoDelete);
        System.out.println(usertoDelete + " Deleted");
        //Writes a file regarding the deleted user
        storedOutput.add("02" + "_" + usertoDelete + "_" + userType + "_" + "00000000" + "_" + "000000000000000" + "_" + "0" + "_" + "000000" + "_"+ "00");


    }

    //Post method
    //Reads the users inputs for the listing up on the site
    public static void post(BufferedReader reader,ArrayList <String> storedOutput) throws NumberFormatException, IOException{
            String cityName;
            int id;

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
            rentalList.add(new Post(cityName, rentalPrice, numbedrooms,id, false));
            for(int i=0; i<rentalList.size()-1; i++) {
                ListIterator<?> iter = rentalList.listIterator(i+1);
                while(iter.hasNext()) {
                    if(rentalList.get(i).equals(iter.next())) {
                        iter.remove();
                    }
                }
            }

            //Generates daily transaction file with posted listing
            
            storedOutput.add("03" + "_" + "0000000000" + "_" + "00" + "_" + id + "_" + cityName + "_" + numbedrooms + "_" + rentalPrice + "_"+ "00");
    }

    //Rent method
    //User rents a unit based on the id and city given
    public static void rent(BufferedReader reader,ArrayList <String> storedOutput) throws NumberFormatException, IOException{
        int id;
        int nights;
        Post rentedPosting = null;
        double totalcost;
        String choice;
        id = 0;
        //Ask user for id of the rental unit
        boolean inputVerify = false;
        while(inputVerify == false){
            System.out.println("Please enter an id ");
            id = Integer.parseInt(reader.readLine());
            if((id > 10000) || (id < 0)){
                continue;
            }else{
                break;
            }
        }
        //Ask user for the nights
        // System.out.println("Please enter the number of nights you are staying");
        // nights = Integer.parseInt(reader.readLine());
        boolean inputVerify2 = false;
        nights = 0;
        while(inputVerify2 == false){
            System.out.println("Please enter the number of nights you are staying");
            nights = Integer.parseInt(reader.readLine());
            if((nights > 365) || (nights < 0)){
                continue;
            }else{
                break;
            }
        }
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
        if (choice.equals("YES") && rentedPosting.getrentedFlag() == false){
            System.out.println("Rental successful");
            rentedPosting.setRented(true);
            storedOutput.add("05" + "_" + "0000000000" + "_" + "00" + "_" + id + "_" + rentedPosting.getCityName() + "_" + rentedPosting.getNumBedrooms() + "_" + totalcost + "_"+ nights);
        }
        else if (choice.equals("NO")){
            System.out.println("Rental cancelled");
        }
        else{
            System.out.println("ERROR: Rental not available anymore");
        }

        //Write a transaction file on rent made
       
        
  
        
    }
    

    //Search method
    //Finds the units by city based on the users input. 
    public static void search(BufferedReader reader, ArrayList <String> storedOutput) throws NumberFormatException, IOException{
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

        //Ask user for minimum amount of bedroomsr
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
        storedOutput.add("04" + "_" + "0000000000" + "_" + "00" + "_" + "000000" + "_" + cityName + "_" + minBedrooms + "_" + maxRentalPrice + "_"+ "00");
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
        return commands;  //Returns the entire file where each line is an index in the array
    }


    public static void linetoArray(String [] userFile, String [] rentalFile){ //Reads in from file to maps
        String[] stringSplit = new String[100];
        for (String user : userFile){
            if (user != null){
            stringSplit = user.split("_"); 
            accountMap.put(stringSplit[0], new User(stringSplit[0], stringSplit[1], stringSplit[2]));
            }
        }
        for (String rental : rentalFile){
            if (rental != null){
            stringSplit = rental.split("_");
            rentalList.add(new Post(stringSplit[0],Double.parseDouble(stringSplit[1]), Integer.parseInt(stringSplit[2]), Integer.parseInt(stringSplit[3]), Boolean.parseBoolean(stringSplit[4])));
            }
        }
    }  


    public static void rewriteAccount(String filename, Map<String,User> accountMap) throws IOException{
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(filename, true))) {
            for (Map.Entry<String,User> entry: accountMap.entrySet() ){
                fw.write(entry.getKey() + "_" + entry.getValue().getPassword() + "_" + entry.getValue().getUserType() );
                fw.newLine();
            }
            fw.close();
        }
    } 

    public static void rewriteRental(String filename, ArrayList<Post> rentList) throws IOException{
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(filename, true))) {
            for (Post entry: rentList ){
                fw.write(entry.getCityName() + "_" + entry.getrentalPrice() + "_" + entry.getNumBedrooms() + "_" + entry.getID() + "_" + entry.getrentedFlag());
                fw.newLine();
            }
            fw.close();
        }
    } 

    public static void writeFile(String filename,ArrayList <String> storedOutput) throws IOException{
    try (BufferedWriter fw = new BufferedWriter(new FileWriter(filename, false))) {
        for (String message: storedOutput ){
            fw.write(message);
            fw.newLine();
        }
        fw.close();
    }

 

    
 
}
    //Main program
    //The start of the program, when users run it they will be prompted with a menu to select an option
    //Based on the given input it will process the command and run the appropriate method
    public static void main(String[] args) throws IOException {
        //Read in inputs from input files
        //Make output only for each user upon logout
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice;
        ArrayList <String> storedOutput = new ArrayList<String>();
        //Menu options
        //To Run, do java otbnb.java rentals.txt users.txt dailyTransactions.txt in a terminal
        String[] userFile =readFile(args[1]); // Contain lines of user file read in 
        String[] rentalFile=readFile(args[0]);//Contain lines of rental file read in 
        linetoArray(userFile, rentalFile); //Takes each line and turns it into an array of Strings which are then inputted into hashmaps
        //TODO LATER: Read user file into User map and rent into Rent map by splitting the list and creating objects

        do{
            System.out.println("Welcome to OT-BnB");
            System.out.println("Please enter option");
            System.out.println("create, delete, login, logout, post, search, exit");
            choice = reader.readLine();
            if (choice.equals("create" )&& currentUser != null){
                create(reader,storedOutput);
                clear(args[1]);
                rewriteAccount(args[1], accountMap);

            }
            else if (choice.equals("delete") && currentUser != null){
                delete(reader,storedOutput);
                clear(args[1]);
                rewriteAccount(args[1], accountMap);

            }
            else if (choice.equals("login") ){
                login(reader);
            }
            else if (choice.equals("logout")){
                logout(args[2],storedOutput);
            }
            else if (choice.equals ("post")&& currentUser != null){
                post(reader,storedOutput);
                clear(args[0]);
                rewriteRental(args[0], rentalList);
            }
            else if (choice.equals ("search")&& currentUser != null){
                search(reader,storedOutput);
            }
            else if (choice.equals ("rent") && currentUser != null){
                rent(reader,storedOutput);
                clear(args[0]);
                rewriteRental(args[0], rentalList);
            }
            else if(choice.equals("exit")){
                System.exit(0);
            }

            else{
                System.out.println("Invalid choice");
                System.out.println("Choices are: create, delete, login, logout, post, search, rent, exit");
            }
          
        }while(!choice.equals("exit")); //exit exits program
    
    }

  

  
}
