public class Menu {

    import java.util.Scanner;

    public class Main{
        public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);
            System.out.println("Tryk y for login");
            if(scanner.nextLine().equalsIgnoreCase("y")) {

                Login login = new Login();
                login.signIn();
            }
            else {
                SignUp signUp = new SignUp("", "");
                signUp.creatNewAccount();
            }
        }
    }

}

import java.util.Scanner;

public class Login {
    public void signIn() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int maxAttempts = 3;

        System.out.println("Login:");

        while (attempts < maxAttempts) {
            String login = scanner.nextLine();

            if (login.equals("Zia90")) {
                System.out.println("Welcome!");
                break;
            } else {
                attempts++;
                if (attempts < maxAttempts) {
                    System.out.println("Try again.");

                }
            }
        }

    }
}


class SignUp {
    public String username ;
    public String password;

    public SignUp (String username,String password ) {
        this.username = username;
        this.password = password;
    }
    public void creatNewAccount(){
        System.out.println(" ( Sign up ) ");
        System.out.println("Enter a Username : ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter your password : ");
        int password = scanner.nextInt();
        System.out.println(" Now you have a new account : " + username+password );

        scanner.close();
    }

}



