package sequential;

import model.Result;
import resources.FileRead;

import java.util.List;
import java.util.Scanner;

public class Main {

    // Class variabels
    private static FileRead file;
    private static List<Result> results;
    private static Scanner input;

    public static void main(String[] args) {

        System.out.print("Enter max year: ");
        input = new Scanner(System.in);
        String inputYear = input.nextLine();
        file = new FileRead();
        results = file.createDataFromFile(inputYear);

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
