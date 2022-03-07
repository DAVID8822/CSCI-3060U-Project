public class Post{ //This is a property object
    //Variables defining the property object
    public String cityName;
    public double rentalPrice;
    public int numbedrooms;
    public boolean rentedFlag = false;
    public int id;
    //Constructor
    public Post(String cityName, double rentalPrice, int numbedrooms, boolean rentedFlag, int id){
        this.cityName = cityName;
        this.rentalPrice = rentalPrice;
        this.numbedrooms = numbedrooms;
        this.rentedFlag = rentedFlag;
        this.id = id;
    }
    
    //Return the name of the property's city
    public String getCityName(){
        return cityName;
    }
   //Return the nightly rental price of the property
    public double getrentalPrice(){
        return rentalPrice;
    }
      //Return the number of bedrooms of the property
    public int getNumBedrooms(){
        return numbedrooms;
    }
    //Returns whether or not the property has been rented
    public boolean getrentedFlag(){
        return rentedFlag;
    }
    //Returns the ID of the property
    public int getID(){
        return id;
    }
    //Used to set whether or not the propety has been rented
    public void setRented(boolean flag){
        this.rentedFlag = flag;
    }
}