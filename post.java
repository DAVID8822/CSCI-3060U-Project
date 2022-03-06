public class Post{
    public String cityName;
    public double rentalPrice;
    public int numbedrooms;
    public boolean rentedFlag = false;
        
    public Post(String cityName, double rentalPrice, int numbedrooms, boolean rentedFlag){
        this.cityName = cityName;
        this.rentalPrice = rentalPrice;
        this.numbedrooms = numbedrooms;
        this.rentedFlag = rentedFlag;
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
}