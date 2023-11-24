import java.util.Scanner;

public class Media {
    private TextUI textUI = new TextUI();

    public Media(TextUI textUI){
        this.textUI = textUI;
    }
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

    public void playSerieOrSave() {
        System.out.println("1. Play");
        System.out.println("2. Save");

        int choice = textUI.getNumericInput("Vælg en mulighed:");

        if (choice == 1) {
            int season = textUI.getNumericInput("Vælg sæson:");
            int episode = textUI.getNumericInput("Vælg episode:");

            System.out.println("Play Serie - Sæson " + season + ", Episode " + episode);
        } else if (choice == 2) {
            System.out.println("Save");
        } else {
            System.out.println("Ugyldigt valg");
        }
    }
}