package resources;

import model.Result;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class dat het CSV bestand gaat uitlezen
 * @author michaelkuijpers, dennisparagusha, abdulahouali
 */
public class FileReadMonth implements FileReader {

    // Class variabelen
    private Scanner fileScanner;
    private File csvFile;
    private List<Result> dataset;
    private List<Result> results;
    private List<Result> searchYear;
    private String date;
    private double temperatuur;

    @Override
    public List<Result> createDataFromFile(String input) {
        // maak een list aan voor de objecten straks
        dataset = new ArrayList<>();
        results = new ArrayList<>();
        // maak een file object op basis van een CSV bestand
        csvFile = new File(Constants.getFilePath());
        // Lezen uit de file
        {
            try {
                fileScanner = new Scanner(csvFile);
                // loop door de file tot er geen volgende regel meer is
                while (fileScanner.hasNextLine()) {
                    // plaats de regel in een string
                    String nextLine = fileScanner.nextLine();
                    // nu elke regel splitten bij de komma
                    String[] lines = nextLine.split(Constants.getRegexKomma());
                    // krijg de date en bewaar alleen het jaar
                    date = lines[0];
                    // krijg temperatuur
                    if(!(lines.length == 1)) {
                        temperatuur = Double.valueOf(lines[1]);
                        // Vul het result in een object en in de list
                        dataset.add(new Result(date, temperatuur));
                    }
                    if(date.equals(input)) {
                        break;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Geen file gevonden");
            }
        }
        return dataset;
    }

}
