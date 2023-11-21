import java.util.ArrayList;

public class User {
    private String username;
    private ArrayList<String> watched;
    private ArrayList<String> saved;

    public User(String username){
        this.username = username;
        this.watched = new ArrayList<>();
        this.saved = new ArrayList<>();
    }

    public String getUsername(){
        return username;
    }

    public ArrayList<String> getSaved() {
        return saved;
    }

    public ArrayList<String> getWatched() {
        return watched;
    }
}
