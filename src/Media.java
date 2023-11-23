import java.util.Scanner;

public class Media {
    private TextUI textUI = new TextUI();

    public String playFilmOrSave() {
        System.out.println("1. Play");
        System.out.println("2. Save");

        int choice = textUI.getNumericInput("Vælg en mulighed:");

        if (choice == 1) {
            return "Play";
        } else if (choice == 2) {
            return "Save";
        } else {
            return "Ugyldigt valg";
        }
    }

    public String playSerieOrSave() {
        System.out.println("1. Play");
        System.out.println("2. Save");

        int choice = textUI.getNumericInput("Vælg en mulighed:");

        if (choice == 1) {
            int season = textUI.getNumericInput("Vælg sæson:");
            int episode = textUI.getNumericInput("Vælg episode:");

            return "Play Serie - Sæson " + season + ", Episode " + episode;
        } else if (choice == 2) {
            return "Save";
        } else {
            return "Ugyldigt valg";
        }
    }
}