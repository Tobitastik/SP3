import java.util.Scanner;

public class Menu {

    TextUI ui = new TextUI();
    private String s = "";
    private String username = "Test";
    private String password = "1234";

    public Menu() {
        System.out.println("Press Y to login or N to make a new user");
        s = ui.getInput("");

        if (s != null) {
            switch (s.toLowerCase()) {
                case "y":
                    System.out.println("Username");
                    newLogin();
                    break;
                case "n":
                    System.out.println("New user");
                    break;
                default:
                    new Menu();
            }
        } else {
            System.out.println("Error: need input");
        }
    }

    private void newLogin() {
        int attempts = 0;
        int maxAttempts = 3;
        s = ui.getInput("");
        if (s.equals(username)) {
            System.out.println("Welcome " + username + ". Please write your password");
            while (attempts < maxAttempts) {
                s = ui.getInput("");
                if (s.equals(password)) {
                    System.out.println("Login is successful");
                    break;
                } else {
                    System.out.println("Try again");
                    attempts++;
                }
            }
        } else {
            System.out.println("Invalid username. Exiting login process.");
        }
    }
}
