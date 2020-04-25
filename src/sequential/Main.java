package sequential;

import model.Result;
import resources.FileReadMonth;
import resources.FileReadYear;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class dat een sort kan uitvoeren
 * @author michaelkuijpers, dennisparagusha, abdulahouali
 */
public class Main {

    // Class variabels
    private static FileReadYear fileReadYear;
    private static FileReadMonth fileReadMonth;
    private static Scanner options, year, month;

    public static void main(String[] args) {

        // Vraag welke keuze
        System.out.print("Do want to sort based on year on month y/m? ");
        options = new Scanner(System.in);
        String option = options.nextLine();
        if(option.equals("j")) {
            // Vraag om het jaartal waar je t/m wil filteren
            System.out.print("Enter max year that you want to sort: ");
            year = new Scanner(System.in);
            String inputYear = year.nextLine();

            // lees de lijst uit op basis van de input jaar
            fileReadYear = new FileReadYear();
            List<Result> results = fileReadYear.createDataFromFile(inputYear);

            // Merge sort de lijst
            MergeSort mergeSort = new MergeSort((ArrayList<Result>) results);
            mergeSort.sortTemperaturen();

            // Toon de resultaten
            toonTemperatures(mergeSort.toonSort());

        } else if(option.equals("m")) {
            // Vraag om het jaartal waar je t/m wil filteren
            System.out.print("Enter max date based on YYYY-MM-DD that you want to sort: ");
            month = new Scanner(System.in);
            String inputMonth = month.nextLine();

            // lees de lijst uit op basis van de input jaar
            fileReadMonth = new FileReadMonth();
            List<Result> results = fileReadMonth.createDataFromFile(inputMonth);

            // Merge sort de lijst
            MergeSort mergeSort = new MergeSort((ArrayList<Result>) results);
            mergeSort.sortTemperaturen();

            // Toon de resultaten
            toonTemperatures(mergeSort.toonSort());
        }

    }

    public static void toonTemperatures(List<Result> list) {
        System.out.println("==============================\n");
        System.out.println("Merge sort temperaturen top 10:");
        for (int i = 0; i < list.size(); i++) {
            Result result = list.get(i);
            System.out.println(result.getYear() + ": " + result.getTemperature());
        }
    }

}
