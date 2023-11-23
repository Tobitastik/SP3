import java.util.Scanner;

public class Media {
    private TextUI textUI = new TextUI();

    public String playFilmOrSave() {
        System.out.println("1. Play");
        System.out.println("2. Save");

        int choice = textUI.getNumericInput("Vælg en mulighed:");

        switch (choice) {
            case 1:
                return "Play";
            case 2:
                return "Save";
            default:
                System.out.println("Ugyldigt valg. Vælg igen.");
                return playFilmOrSave(); // Rekursivt kald ved ugyldigt valg
        }
    }

    public String playSerieOrSave() {
        System.out.println("1. Play");
        System.out.println("2. Save");

        int choice = textUI.getNumericInput("Vælg en mulighed:");

        switch (choice) {
            case 1:
                int season = textUI.getNumericInput("Vælg sæson:");
                int episode = textUI.getNumericInput("Vælg episode:");
                return "Play Serie - Sæson " + season + ", Episode " + episode;
            case 2:
                return "Save";
            default:
                System.out.println("Ugyldigt valg. Vælg igen.");
                return playSerieOrSave(); // Rekursivt kald ved ugyldigt valg
        }
    }
}
