
import otbnb.java;

class ServiceStub extends otbnb {
    @Override
    public static void login(){
        loggedIn = true;
        currentUser =  accountMap.get("admin");

    }
    public static void logout(){
        currentUser = null;
        loggedIn = false;
        writeFile("dailyTransactions.txt","00" + "_" + currentUser.name + "_" + currentUser.userType + "_" + "00000000" + "_" + "000000000000000" + "_" + "0" + "_" + "000000" + "_"+ "00");

    }
    public static void create(){
        accountMap.put("newuser", new User("newuser", "123", "BS"));
        writeFile("dailyTransactions.txt","01" + "_" + accountMap.get("newuser").getUser + "_" + "123" + "_" + "00000000" + "_" + "000000000000000" + "_" + "0" + "_" + "000000" + "_"+ "00");
    }

    public static void delete(){
        accountMap.remove("newuser");
        writeFile("dailyTransactions.txt","02" + "_" + accountMap.get("newuser").name + "_" + accountMap.get("newuser").userType + "_" + "00000000" + "_" + "000000000000000" + "_" + "0" + "_" + "000000" + "_"+ "00");

    }

    public static void post(){
        rentalList.add(new Post("Nowhere", 1.0, 3,1337, false));
        writeFile("dailyTransactions.txt","03" + "_" + "0000000000" + "_" + "00" + "_" + rentalList.getID(1337).getID + "_" + rentalList.getID(1337).getCityName + "_" + rentalList.getID(1337).getNumBedrooms + "_" + rentalList.getID(1337).getrentalPrice + "_"+ "00");
    }

    public static void rent(){
        nights = 4;
        rentalList.getID(1337).setRented = true;   
        writeFile("dailyTransactions.txt","05" + "_" + "0000000000" + "_" + "00" + "_" + rentalList.get.getID(1337).getID + "_" + rentalList.getID(1337).getCityName + "_" + rentalList.getID(1337).getNumBedrooms + "_" + rentalList.getID(1337).getrentalPrice + "_"+ "00") + "_"+ nights);
    }
    public static void search(){
        minBedrooms = 1;
        maxRentalPrice = 100;
        Post x = rentalList.getID(1337);
        System.out.println("City name " + x.getCityName());
        System.out.println("Rental price " + x.getrentalPrice());
        System.out.println("Number of bedrooms " + x.getNumBedrooms());
        System.out.println("ID:" + x.getID());
        writeFile("dailyTransactions.txt","04" + "_" + "0000000000" + "_" + "00" + "_" + "000000" + "_" + rentalList.getID(1337).getCityName + "_" + minBedrooms + "_" + maxRentalPrice + "_"+ "00");
    }

    public static void main(String args[]){
        login();
        logout();
        create();
        delete();
        post();
        search();

    }
}