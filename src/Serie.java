import java.util.ArrayList;

public class Serie {

    private String name;
    private String year;
    private ArrayList<String> categories;
    private double rating;
    private ArrayList<String> season;

    public Serie(String name, String year, ArrayList<String> catagories, double rating, ArrayList<String> season){

        this.name = name;
        this. year = year;
        this.categories = catagories;
        this.rating = rating;
        this.season = season;

    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
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
    public String toString(){
        return "Serie{"+
                "Name = "+name+
                ", Year = "+year+
                ", Categories = " +categories+
                ", Rating = " + rating +
                ", Season = " + season+"}";

    }


}