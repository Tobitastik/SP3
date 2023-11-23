import java.util.ArrayList;

public class UserMenu {
    private TextUI ui;
    private ArrayList<Serie> series;
    private ArrayList<Film> films;

    public UserMenu(TextUI ui, ArrayList<Film> films, ArrayList<Serie> series) {
        this.ui = ui;
        this.series = series;
    }

    public void chooseMenu(TextUI ui, ArrayList<Film> films, ArrayList<Serie> series) {
        int choice;
        do {
            displayMenu();
            choice = ui.getNumericInput("Chose your search method");
            switch (choice) {
                case 1:
                    searchForSerieName();
                    break;
                case 2:
                    searchForSerieYear();
                    break;
                case 0:
                    System.out.println("Exiting menu");
                    break;
                default:
                    System.out.println("Invalid choice, try again please");
                    break;
            }
        } while (choice != 0);
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
                    // adding if no end year
                    searchResults.add(serie);
                }
            } else {
                if (yearString.contains(Integer.toString(searchYear))) {
                    searchResults.add(serie);
                }
            }
        }

        displaySearchResults(searchResults);
    }



    private void displaySearchResults(ArrayList<? extends MediaInterface> searchResults){
        if(searchResults.isEmpty()){
            System.out.println("No media match found");
        } else {
            System.out.println("Search results:");
                for(MediaInterface media : searchResults){
                    System.out.println(media.display());
                }
            }
    }

}
