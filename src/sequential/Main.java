package sequential;

import model.Result;
import resources.FileRead;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Class variabels
    private static FileRead file;
    private static List<Result> results;

    public static void main(String[] args) {

        file = new FileRead();
        results = file.createDataFromFile();

        testIfFileHasLines(results);

    }

    /**
     * Methode om te kijken of er wel objecten in de lijst zitten
     */
    public static void testIfFileHasLines(List<Result> list) {
        for (int i = 0; i < results.size(); i++) {
            Result result = results.get(i);
            System.out.println(result.getYear() + ": " + result.getTemperature());
        }
    }

}
