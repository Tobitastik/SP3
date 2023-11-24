import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {
    public FileIO fileIO = new FileIO(); // Kalder på FileIO klassen
    public TextUI ui = new TextUI(); // Kalder på TextUI klassen
    private ArrayList<Film> readFilmData = new ArrayList<>(); // Arraylist af vores film

    public void Runner() {
        readFilmData = fileIO.readFilmData(); // Kalder på readFilmData Arraylisten for filmene fra FileIO klassen
        input();

    }

    /*
        private void MovieList() // listen over alle filmene
        {
            String a = "\nmovie list:\n";
            for (Film films : readFilmData) {
                a = a.concat(films.toString() + "\n");
            }
            ui.getInput(a);
        }
     */

    private void input() // input af tekst i console om hvad man vil søge efter, samt om man finder en film/serie af det man søger efter
    {
        Scanner scanner = new Scanner(System.in);


        FilmCollection filmCollection = new FilmCollection(readFilmData);

        System.out.println("Enter the type you will search for (Name/Year/Category/Rating): ");
        String searching = scanner.nextLine();

        if ("Name".equalsIgnoreCase(searching)) {
            System.out.println("Enter Name: ");
            String searchName = scanner.nextLine();
            filmCollection.searchByName(searchName);
        } else if ("Year".equalsIgnoreCase(searching)) {
            System.out.println("Enter Year: ");
            int searchAge = scanner.nextInt();
            filmCollection.searchByAge(searchAge);
        } else if ("Rating".equalsIgnoreCase(searching)) {
            System.out.println("Enter Rating: ");
            double searchRating = scanner.nextDouble();
            filmCollection.searchByRating(searchRating);
        } else if ("Category".equalsIgnoreCase(searching)) {
            System.out.println("Enter Category: ");
            String searchCat = scanner.nextLine();
            filmCollection.searchByCat(searchCat);
        } else {
            System.out.println("Invalid");

        }
        scanner.close();
    }

    static class FilmCollection { // arraylist af film i FilmCollection klassen
        private final ArrayList<Film> readFilmData;

        public FilmCollection(ArrayList<Film> readFilmData) { // initializer readFilmData Arraylisten
            this.readFilmData = readFilmData;

        }

        public void searchByName(String searchName) // bruges til at søge efter navn af filmene
        {
            TextUI ui = new TextUI();

            String lowerCaseSearchName = searchName.toLowerCase();

            boolean found = false;

            System.out.println("\nResults for search: " + searchName);


            for (Film film : readFilmData) {
                if (film.getName().toLowerCase().contains(lowerCaseSearchName)) {
                    System.out.println(film);
                    found = true;
                }
            }


            if (!found) {

                String userInput = ui.getInput("No films found");
                System.out.println(userInput + searchName);
            }
        }

        public void searchByAge(int searchAge) // søger for udgivelsesdatoen af filmene
        {

            TextUI ui = new TextUI();

            boolean found = false;

            System.out.println("\nResults for search: " + searchAge);

            for (Film film : readFilmData) {
                if (film.getYear() == searchAge) {
                    System.out.println(film);
                    found = true;
                }
            }

            if (!found) {
                String userInput = ui.getInput("No films found: " + searchAge);
                System.out.println(userInput);
            }
        }

        public void searchByCat(String searchCategory) // søger efter categori af filmene
        {

            TextUI ui = new TextUI();

            boolean found = false;

            System.out.println("\nResults for search: " + searchCategory);

            for (Film film : readFilmData) {
                if (film.getCategories().contains(searchCategory)) {
                    System.out.println(film);
                    found = true;
                }
            }


            if (!found) {
                String userInput = ui.getInput("No films found: " + searchCategory);
                System.out.println(userInput);
            }
        }

        public void searchByRating(double searchRating) // søger for rating af filmene
        {

            TextUI ui = new TextUI();

            boolean found = false;

            System.out.println("\nResults for search: " + searchRating);


            for (Film film : readFilmData) {
                if (film.getRating() == searchRating) {
                    System.out.println(film);
                    found = true;
                }
            }


            if (!found) {
                String userInput = ui.getInput("No films found: " + searchRating);
                System.out.println(userInput);
            }
        }


    }
}








