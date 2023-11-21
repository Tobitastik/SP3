import java.io.File;
import java.io.FileNotFoundException;
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

    public ArrayList<String> readAccountData(){
        ArrayList<String> dataA = new ArrayList<>();
        File fileA = new File("data/accounts.txt");

    try{
        Scanner scanner = new Scanner(fileA);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            dataA.add(s);
        }
    } catch (FileNotFoundException e){
        ui.getInput("File not found (accounts)");
    }
        return dataA;
    }
}
