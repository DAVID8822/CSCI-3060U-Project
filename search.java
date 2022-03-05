import java.util.ArrayList;
public class Search{
    public String cityName;
    public ArrayList<String> citiesAr = new ArrayList<String>();
    public ArrayList<String> resultAr = new ArrayList<String>();

    public Search(String cityName, ArrayList citesAr,  ArrayList resultAr){
        this.citiesAr = citiesAr;
        this.resultAr = resultAr;
        this.cityName = cityName;
    }
    
    public String getCityName(String cityName, ArrayList citesAr,  ArrayList resultAr){
        return cityName;
    }
    public String searchList(String cityName, ArrayList citesAr,  ArrayList resultAr){
        // loop through the potentialCity names 
        for(String x: citiesAr)
        // If you find a match with the name
            if(x.matches(getCityName()))
            // add all of the matching units to the arraylist
                resultAr.add(x);
                // return the matches arr
        return resultAr;
    }
}