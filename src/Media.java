import java.util.Scanner;

public class Media {
    private TextUI textUI = new TextUI();

    public String playFilmOrSave() {
        System.out.println("1. Play");
        System.out.println("2. Save");

        int choice = textUI.getNumericInput("V�lg en mulighed:");

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

        int choice = textUI.getNumericInput("V�lg en mulighed:");

        if (choice == 1) {
            int season = textUI.getNumericInput("V�lg s�son:");
            int episode = textUI.getNumericInput("V�lg episode:");

            return "Play Serie - S�son " + season + ", Episode " + episode;
        } else if (choice == 2) {
            return "Save";
        } else {
            return "Ugyldigt valg";
        }
    }
}