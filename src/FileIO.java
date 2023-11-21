import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    TextUI ui = new TextUI();


    public ArrayList<String[]> readFilmData() {
        ArrayList<String[]> dataF = new ArrayList<>();
        File fileF = new File("data/100bedstefilm.txt");

        try (Scanner scanner = new Scanner(fileF)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tempDataF = line.split(";");
                dataF.add(tempDataF);

            }
        } catch (FileNotFoundException e) {
            ui.getInput("File not found (Film)");

        }

        return dataF;
    }

    public ArrayList<String[]> readSerieData() {
        ArrayList<String[]> dataS = new ArrayList<>();
        File fileS = new File("data/100bedsteserier.txt");

        try (Scanner scanner = new Scanner(fileS)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tempDataS = line.split(";");
                dataS.add(tempDataS);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found (Serie)");
        }

        return dataS;
    }

    public void writeUsersToFile(ArrayList<User> users, String path){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            for(User user : users){
                writer.write(user.getUsername());
                writer.newLine();
            }
            System.out.println("Account updated");
            displayUsers(users);


        } catch (IOException e){
            System.out.println("Error updating accounts");
        }
    }

    public void displayUsers(ArrayList<User> users){
        System.out.println("Users:");
        for(User user : users){
            System.out.println(user.getUsername());
        }
    }

}
