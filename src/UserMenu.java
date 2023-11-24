import java.util.ArrayList;

public class UserMenu {
    private TextUI ui;
    private Media media;
    private ArrayList<Serie> series;
    private ArrayList<Film> films;
    private Menu menu;
    public User user;


    public UserMenu(TextUI ui, ArrayList<Film> films, ArrayList<Serie> series, Menu menu) {
        this.ui = ui;
        this.series = series;
        this.films = films;
        this.media = new Media(ui);
        this.menu = menu;
    }


    public void chooseMenu() {
        int choice;

        displayMenu();
        choice = ui.getNumericInput("Chose your search method");
        switch (choice) {
            case 1:
                searchForSerieName();
                break;
            case 2:
                searchForSerieYear();
                break;
            case 3:
                searchForCategories();
                break;
            case 4:
                searchForRating();
                break;
            case 5:
                searchForSeason();
                break;
            case 0:
                System.out.println("Exiting menu");
                break;
            default:
                System.out.println("Invalid choice, try again please");
                break;
        }
    }



    private void displayMenu(){
        System.out.println("1. Search by name");
        System.out.println("2. Search by year");
        System.out.println("3. Search by categories");
        System.out.println("4. Search by rating");
        System.out.println("5. Search by season");
    }
    private void searchForSerieName() {
        String searchName = ui.getInput("Enter name search:");
        ArrayList<Serie> searchResults = new ArrayList<>();

        for (Serie serie : series) {
            if (serie.getName().toLowerCase().contains(searchName.toLowerCase())) {
                searchResults.add(serie);
            }
        }
        displaySearchResults(searchResults);

        if(!searchResults.isEmpty()) {
            int selectedSerieIndex = ui.getNumericInput("Chose serie based on the number");

            if (selectedSerieIndex >= 1 && selectedSerieIndex <= searchResults.size()) {
                Serie selectedSerie = searchResults.get(selectedSerieIndex - 1);
                System.out.println(selectedSerie.getName());
                media.playSerieOrSave();

            } else {
                System.out.println("Please enter valid number");
            }
        }
    }

    private void searchForSerieYear() {
        int searchYear = ui.getNumericInput("Enter year:");
        ArrayList<Serie> searchResults = new ArrayList<>();

        for (Serie serie : series) {
            String yearString = serie.getYear();
            if (yearString.contains("-")) {
         String[] yearRange = yearString.split("-");
                int startYear = Integer.parseInt(yearRange[0].trim());

                if (yearRange.length > 1 && !yearRange[1].trim().equals("")) {
                    int endYear = Integer.parseInt(yearRange[1].trim());
                    if (searchYear >= startYear && searchYear <= endYear) {
                        searchResults.add(serie);
                    }
                } else {

                    searchResults.add(serie);
                }
            } else {
                if (yearString.contains(Integer.toString(searchYear))) {
                    searchResults.add(serie);
                }
            }
        }

        displaySearchResults(searchResults);

        if(!searchResults.isEmpty()) {
            int selectedSerieIndex = ui.getNumericInput("Chose serie based on the number");

            if (selectedSerieIndex >= 1 && selectedSerieIndex <= searchResults.size()) {
                Serie selectedSerie = searchResults.get(selectedSerieIndex - 1);
                System.out.println(selectedSerie.getName());
                media.playSerieOrSave();

            } else {
                System.out.println("Please enter valid number");
            }
        }
    }
    private void searchForCategories() {
        String searchCategory = ui.getInput("Enter category search:");
        ArrayList<Serie> searchResults = new ArrayList<>();

        for (Serie serie : series) {
            for (String category : serie.getCategories()) {
                if (category.toLowerCase().contains(searchCategory.toLowerCase())) {
                    searchResults.add(serie);
                    break;
                }
            }
        }

        displaySearchResults(searchResults);

        if (!searchResults.isEmpty()) {
            int selectedSerieIndex = ui.getNumericInput("Choose serie based on the number");

            if (selectedSerieIndex >= 1 && selectedSerieIndex <= searchResults.size()) {
                Serie selectedSerie = searchResults.get(selectedSerieIndex - 1);
                System.out.println(selectedSerie.getName());
                media.playSerieOrSave();
            } else {
                System.out.println("Please enter a valid number");
            }
        }
    }
    private void searchForRating() {
        double searchRating = ui.getDoubleInput("Enter minimum rating:");

        ArrayList<Serie> searchResults = new ArrayList<>();

        for (Serie serie : series) {
            if (serie.getRating() >= searchRating) {
                searchResults.add(serie);
            }
        }

        displaySearchResults(searchResults);

        if (!searchResults.isEmpty()) {
            int selectedSerieIndex = ui.getNumericInput("Choose serie based on the number");

            if (selectedSerieIndex >= 1 && selectedSerieIndex <= searchResults.size()) {
                Serie selectedSerie = searchResults.get(selectedSerieIndex - 1);
                System.out.println(selectedSerie.getName());
                media.playSerieOrSave();
            } else {
                System.out.println("Please enter a valid number");
            }
        }
    }
    private void searchForSeason() {
        int searchSeason = ui.getNumericInput("Enter season search:");
        ArrayList<Serie> searchResults = new ArrayList<>();

        for (Serie serie : series) {
            for (Season season : serie.getSeason()) {
                int seasonNumber;
                try {
                    seasonNumber = Integer.parseInt(season.getNumberOfSeasons());
                } catch (NumberFormatException e) {
                    continue;
                }

                if (seasonNumber == searchSeason) {
                    searchResults.add(serie);
                    break;
                }
            }
        }

        displaySearchResults(searchResults);

        if (!searchResults.isEmpty()) {
            int selectedSerieIndex = ui.getNumericInput("Choose serie based on the number");

            if (selectedSerieIndex >= 1 && selectedSerieIndex <= searchResults.size()) {
                Serie selectedSerie = searchResults.get(selectedSerieIndex - 1);
                System.out.println(selectedSerie.getName());
                media.playSerieOrSave();
            } else {
                System.out.println("Please enter a valid number");
            }
        }
    }

    private void displaySearchResults(ArrayList<? extends MediaInterface> searchResults){
        int index = 0;
        if(searchResults.isEmpty()){
            System.out.println("No media match found");
        } else {
            System.out.println("Search results:");
                for(MediaInterface media : searchResults){
                    System.out.println(index+1);
                    System.out.println(media.display());
                    index++;
                    System.out.println();
                }
            }
   }

}
