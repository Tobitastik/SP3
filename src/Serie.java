import java.util.ArrayList;

public class Serie implements MediaInterface{

    private String name;
    private String year;
    private ArrayList<String> categories;
    private double rating;
    private ArrayList<String> season;

    private String startYear;
    private String endYear;

    public Serie(String name, String year, ArrayList<String> categories, double rating, ArrayList<String> season){

        this.name = name;
        this. year = year;
        this.categories = categories;
        this.rating = rating;
        this.season = season;

    }

    public String getName() {
        return name;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getYear() {
        if(startYear != null && endYear != null) {
           return startYear + "-"+ endYear;
        } else if(startYear != null){
           return startYear;
        } else{
           return"";
        }

    }


    public ArrayList<String> getCategories() {
        return categories;
    }

    public double getRating() {
        return rating;
    }

    public ArrayList<String> getSeason() {
        return season;
    }

    @Override
    public String display(){
        return "Serie{"+
                "Name = "+name+
                ", Year = "+year+
                ", Categories = " +categories+
                ", Rating = " + rating +
                ", Season = " + season+"}";

    }


}