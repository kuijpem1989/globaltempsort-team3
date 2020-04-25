package sequential;

import model.Result;
import resources.FileRead;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class dat een sort kan uitvoeren
 * @author michaelkuijpers, dennisparagusha, abdulahouali
 */
public class Main {

    // Class variabels
    private static FileRead file;
    private static Scanner input;

    public static void main(String[] args) {

        // Vraag om het jaartal waar je t/m wil filteren
        System.out.print("Enter max year: ");
        input = new Scanner(System.in);
        String inputYear = input.nextLine();
        // lees de lijst uit op basis van de input jaar
        file = new FileRead();
        List<Result> results = file.createDataFromFile(inputYear);

        // Merge sort de lijst
        MergeSort test = new MergeSort((ArrayList<Result>) results);
        test.sortTemperaturen();
        // Toon de resultaten
        test.toonSort();

    }

}
