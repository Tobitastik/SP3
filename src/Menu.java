public class Menu {

    TextUI ui = new TextUI();
    private String s = "";
    public Menu(){
        System.out.println("Press Y to login or N to make a new user");
        s = ui.getInput();
        if(s.equalsIgnoreCase("y"))
            System.out.println("User");
        else if (s.equalsIgnoreCase("N"))
            System.out.println("New user");
        else
            new Menu();
    }

    public void login(){
        int attempts = 0;
        int maxattempts = 3;

        while (attempts < maxattempts){

        }
    }
}




