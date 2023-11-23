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
                String yearString = tempDataS[1].trim();
                String[] categories = tempDataS[2].trim().split(",");
                String ratingString = tempDataS[3].replace(",",".");
                double rating = Double.parseDouble(ratingString);
                String[] season = tempDataS[4].trim().split(",");

                Serie serie = new Serie(name, yearString, new ArrayList<>(Arrays.asList(categories)), rating, new ArrayList<>(Arrays.asList(season)));
                setStartAndEndYear(serie, yearString);

                series.add(serie);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found (Serie)");
        }

        return series;
    }

    private void setStartAndEndYear(Serie serie, String yearString) {
        if (yearString.contains("-")) {
            String[] yearRange = yearString.split("-");
            serie.setStartYear(yearRange[0].trim());
            if (yearRange.length > 1 && !yearRange[1].trim().equals("")) {
                serie.setEndYear(yearRange[1].trim());
            } else {

                serie.setEndYear("2023");
            }
        } else {

            serie.setStartYear(yearString);
        }
    }

    public void writeUsersToFile(ArrayList<User> users, String path) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            for (User user : users) {
                writer.write(user.getUsername());
                writer.write(";");


                writer.write("Watched Movies:");
                for(Film film : user.getFilmWatched()) {
                    writer.write(film.getName());
                    writer.write(",");
                }

                writer.write(";Saved Movies:");
                for(Film film : user.getFilmSaved()) {
                    writer.write(film.getName());
                    writer.write(",");
                }

                writer.write(";Watched Series");
                for(Serie serie : user.getSerieWatched()) {
                    writer.write(serie.getName());
                    writer.write(",");
                }

                writer.write(";Saved Series");
                for(Serie serie : user.getSerieSaved()){
                    writer.write(serie.getName());
                    writer.write(",");
                }
                writer.newLine();
            }

            System.out.println("Account updated");
            //displayUsers(ArrayList<User> users);


        } catch (IOException e) {
            System.out.println("Error updating accounts");
        }
    }

    //Skal laves lidt om
 /*   public ArrayList<User> readUsersFromFile(String path) {
        ArrayList<User> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String userLine = scanner.nextLine();
                String[] tempUser = userLine.split(";");

                String username = tempUser[0];

                // Extract watched movies
                String watchedMoviesSection = tempUser[1].substring("Watched Movies:".length());
                String[] watchedMoviesData = watchedMoviesSection.split(",");
                ArrayList<Film> watchedMovies = new ArrayList<>();
                for (String movieName : watchedMoviesData) {
                    Film movie = createFilm(movieName.trim());
                    if (movie != null) {
                        watchedMovies.add(movie);
                    }
                }

                // Extract saved movies
                String savedMoviesSection = tempUser[2].substring("Saved Movies:".length());
                String[] savedMoviesData = savedMoviesSection.split(",");
                ArrayList<Film> savedMovies = new ArrayList<>();
                for (String movieName : savedMoviesData) {
                    Film movie = createFilm(movieName.trim());
                    if (movie != null) {
                        savedMovies.add(movie);
                    }
                }

                // Extract watched series
                String watchedSeriesSection = tempUser[3].substring("Watched Series:".length());
                String[] watchedSeriesData = watchedSeriesSection.split(",");
                ArrayList<Serie> watchedSeries = new ArrayList<>();
                for (String serieName : watchedSeriesData) {
                    Serie serie = createSerie(serieName.trim());
                    if (serie != null) {
                        watchedSeries.add(serie);
                    }
                }

                // Extract saved series
                String savedSeriesSection = tempUser[4].substring("Saved Series:".length());
                String[] savedSeriesData = savedSeriesSection.split(",");
                ArrayList<Serie> savedSeries = new ArrayList<>();
                for (String serieName : savedSeriesData) {
                    Serie serie = createSerie(serieName.trim());
                    if (serie != null) {
                        savedSeries.add(serie);
                    }
                }

                User newUser = new User(username);
                newUser.getFilmWatched().addAll(watchedMovies);
                newUser.getFilmSaved().addAll(savedMovies);
                newUser.getSerieWatched().addAll(watchedSeries);
                newUser.getSerieSaved().addAll(savedSeries);

                users.add(newUser);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found (" + path + ")");
        }

        return users;
    }


    public ArrayList<User> readUsersFromFile() {
        return readUsersFromFile("data/accounts.txt");
    }*/

    public void displayUsers(ArrayList<User> users){
        System.out.println("Users:");
        for(User user : users){
            System.out.println(user.getUsername());
        }
    }

}