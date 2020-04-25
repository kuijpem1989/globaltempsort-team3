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
    private static Scanner year;
    private static Scanner askOnsorted;
    private static List<Result> onsorted;

    public static void main(String[] args) {

        // Vraag om het jaartal waar je t/m wil filteren
        System.out.print("Enter max year that you want to sort: ");
        year = new Scanner(System.in);
        String inputYear = year.nextLine();
        // Vraag of de ongesorte lijst ook getoond moet worden
        System.out.print("Do you also want to see the onsorted list first j/n? ");
        askOnsorted = new Scanner(System.in);
        String answerOnSorted = askOnsorted.nextLine();
        // lees de lijst uit op basis van de input jaar
        file = new FileRead();
        List<Result> results = file.createDataFromFile(inputYear);
        onsorted = file.createDataFromFile(inputYear);
        onSortedPrint(answerOnSorted, inputYear);

        // Merge sort de lijst
        MergeSort test = new MergeSort((ArrayList<Result>) results);
        test.sortTemperaturen();
        // Toon de resultaten
        test.toonSort();

    }

    /**
     * Maakt een print wanneer er een behoefte is tot een onsorted print
     * @param answerOnSorted
     */
    private static void onSortedPrint(String answerOnSorted, String inputYear) {
        System.out.println("Onsorted list:");
        if(answerOnSorted.equals("j")) {
            for(int i = 0; i < onsorted.size(); i++) {
                Result result = onsorted.get(i);
                System.out.println(result.getYear() + ": " + result.getTemperature());
            }
        } else {
            return;
        }
        System.out.println("==============================\n");
    }

}
