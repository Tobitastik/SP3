import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    private TextUI ui = new TextUI();
    private ArrayList<User> users = new ArrayList<>();
    private String s = "";
    private String username = "Test";
    private String password = "1234";

    public Menu() {
        displayMenu();
    }

    private void displayMenu() {
        FileIO io = new FileIO();

        do {
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
                        System.out.println("Invalid input please try again");
                }
            } else {
                System.out.println("Error: need input");
            }
        } while (!s.toLowerCase().equals("y") && !s.toLowerCase().equals("n"));
    }

    private void createUser() {
        String newUsername = ui.getInput("Enter new username");
        User newUser = new User(newUsername);
        users.add(newUser);
        System.out.println("User " + newUser.getUsername() + " created");

        FileIO io = new FileIO();
        io.writeUsersToFile(users, "data/accounts.txt");
    }


    private void newLogin() {
        FileIO io = new FileIO();
        ArrayList<User> usersFromFile = io.readUsersFromFile();
        io.displayUsers(usersFromFile);
        int choice = ui.getNumericInput("Choose your account");


        switch (choice) {
            case 1:
                if (!usersFromFile.isEmpty() && choice <= usersFromFile.size()) {
                    User selectedUser = usersFromFile.get(choice - 1);
                    System.out.println("welcome " + selectedUser.getUsername());
                } else {
                    System.out.println("Invalid choice, Please choose another account");
                }
                break;
            default:
                System.out.println("Invalid choice, Please choose another account");
                break;
        }

    /*public ArrayList<User> getUsers() {
        return users;
    }*/


       /* private void displayUsers (ArrayList < User > users) {
            System.out.println("Users:");
            for (User user : users) {
                System.out.println(user.getUsername());
            }
        }*/
    }
}