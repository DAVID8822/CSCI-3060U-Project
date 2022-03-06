public class Post{
    public String cityName;
    public double rentalPrice;
    public int numbedrooms;
    public boolean rentedFlag = false;
    public int id;
    public Post(String cityName, double rentalPrice, int numbedrooms, boolean rentedFlag, int id){
        this.cityName = cityName;
        this.rentalPrice = rentalPrice;
        this.numbedrooms = numbedrooms;
        this.rentedFlag = rentedFlag;
        this.id = id;
    }
    
    public String getCityName(){
        return cityName;
    }
    public double getrentalPrice(){
        return rentalPrice;
    }
    public int getNumBedrooms(){
        return numbedrooms;
    }
    public int getrentedFlag(){
        return numbedrooms;
    }
    public int getID(){
        return id;
    }

    public void setRented(boolean flag){
        this.rentedFlag = flag;
    }
}