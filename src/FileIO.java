import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public ArrayList<String[]> readFilmData(String path) {
        ArrayList<String[]> data = new ArrayList<>();
        File file = new File(path);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tempDataF = line.split(",");
                data.add(tempDataF);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found (Film)");
        }

        return data;
    }

   public ArrayList<String[]> readSerieData(String path) {
        ArrayList<String[]> dataS = new ArrayList<>();
        File file2 = new File(path);

        try (Scanner scanner = new Scanner(file2)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tempDataS = line.split(",");
                dataS.add(tempDataS);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found (Serie)");
        }
        return dataS;
   }
}
