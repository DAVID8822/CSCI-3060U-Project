public class Rental{
    public String city;
    public double rentalPrice;
    public int bedrooms;
    public boolean rented = false;
        
    public Rental(String city, double rentalPrice, int bedrooms){
        this.city = city;
        this.rentalPrice = rentalPrice;
        this.bedrooms = bedrooms;
    }
    
    public String getCity(){
        return city;
    }
    public double getrentalPrice(){
        return rentalPrice;
    }
    public int getBedrooms(){
        return bedrooms;
    }
    }