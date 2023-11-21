import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public ArrayList<String[]> readFilmData(String path) {
        ArrayList<String[]> dataF = new ArrayList<>();
        File fileF = new File(path);

        try (Scanner scanner = new Scanner(fileF)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tempDataF = line.split(";");
                dataF.add(tempDataF);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found (Film)");
        }

        return dataF;
    }

    public ArrayList<String[]> readSerieData(String path) {
        ArrayList<String[]> dataS = new ArrayList<>();
        File fileS = new File(path);

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
}
