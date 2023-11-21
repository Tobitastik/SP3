import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    TextUI ui = new TextUI();
    private ArrayList<User> users = new ArrayList<>();
    private String s = "";
    private String username = "Test";
    private String password = "1234";

    public Menu() {

        s = ui.getInput("Press Y to login or N to make a new user");

        if (s != null) {
            switch (s.toLowerCase()) {
                case "y":
                    newLogin();
                    break;
                case "n":
                    //System.out.println("New user");
                    createUser();
                    break;
                default:
                    new Menu();
            }
        } else {
            System.out.println("Error: need input");
        }
    }

    private void createUser() {
        String newUsername = ui.getInput("Enter new username");
        User newUser = new User(newUsername);
        users.add(newUser);
        System.out.println("User "+ newUser.getUsername() +" created");

        FileIO io = new FileIO();
        io.writeUsersToFile(users, "data/accounts.txt");
    }


    private void newLogin() {
        displayUsers(users);
        ui.getNumericInput("Choose your account");
    }


    private void displayUsers(ArrayList<User> users){
        System.out.println("Users:");
        for(User user : users){
            System.out.println(user.getUsername());
        }
    }


}
