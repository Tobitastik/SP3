import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        FileIO io = new FileIO();
        String filePath = "data/100bedstefilm.txt";
        String filePath2 = "data/100bedsteserier.txt";

        ArrayList<String[]> filmData = io.readFilmData(filePath);
        //ArrayList<String[]> serieData = io.readSerieData(filePath2);
        System.out.println(Arrays.toString(filmData.get(20)));
        //System.out.println(Arrays.toString(serieData.get(2)));

        new Menu();

        /*TextUI ui = new TextUI();

        System.out.println("Test");
        System.out.println(ui.getInput());*/

    }
}