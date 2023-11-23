import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileIO {

    TextUI ui = new TextUI();


   public ArrayList<Film> readFilmData() {
        ArrayList<Film> films = new ArrayList<>();
        File fileF = new File("data/100bedstefilm.txt");

        try (Scanner scanner = new Scanner(fileF)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tempDataF = line.split(";");

                String name = tempDataF[0];
                int year = Integer.parseInt(tempDataF[1].trim());
                String[] categories = tempDataF[2].trim().split(",");
                String ratingString = tempDataF[3].replace(",",".");
                double rating = Double.parseDouble(ratingString);

                Film film = new Film(name, year, new ArrayList<>(Arrays.asList(categories)), rating);


                films.add(film);


            }
        } catch (FileNotFoundException e) {
            ui.getInput("File not found (Film)");

        }

        return films;
   }

    public ArrayList<Serie> readSerieData() {
        ArrayList<Serie> series = new ArrayList<>();
        File fileS = new File("data/100bedsteserier.txt");

        try (Scanner scanner = new Scanner(fileS)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tempDataS = line.split(";");

                String name = tempDataS[0];
                String year = tempDataS[1].trim();
                String[] categories = tempDataS[2].trim().split(",");
                String ratingString = tempDataS[3].replace(",",".");
                double rating = Double.parseDouble(ratingString);
                String[] season = tempDataS[4].trim().split(",");

                Serie serie = new Serie(name, year, new ArrayList<>(Arrays.asList(categories)), rating, new ArrayList<>(Arrays.asList(season)));

                series.add(serie);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found (Serie)");
        }

        return series;
    }

    public void writeUsersToFile(ArrayList<User> users, String path) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (User user : users) {
                User[] userData ={user};
            }
            System.out.println("Account updated");
            //displayUsers(ArrayList<User> users);


        } catch (IOException e) {
            System.out.println("Error updating accounts");
        }
    }

    //Skal laves lidt om
    public ArrayList<User> readUsersFromFile(String path) {
        ArrayList<User> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String userLine = scanner.nextLine();
                String[] tempUser = userLine.split(",");


                String username = tempUser[0];
                ArrayList<String> watched = new ArrayList<>(Arrays.asList(tempUser[1].split(",")));
                ArrayList<String> saved = new ArrayList<>(Arrays.asList(tempUser[2].split(",")));


                User newUser = new User(username);
                newUser.getWatched().addAll(watched);
                newUser.getSaved().addAll(saved);
                users.add(newUser);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found (" + path + ")");
        }

        return users;
    }


    public ArrayList<User> readUsersFromFile() {
        return readUsersFromFile("data/accounts.txt");
    }

    public void displayUsers(ArrayList<User> users){
        System.out.println("Users:");
        for(User user : users){
            System.out.println(user.getUsername());
        }
    }

}
