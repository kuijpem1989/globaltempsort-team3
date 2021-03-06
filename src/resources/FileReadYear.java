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
public class FileReadYear implements FileReader {

    // Class variabelen
    private Scanner fileScanner;
    private File csvFile;
    private List<Result> dataset;
    private List<Result> filterList;
    private List<Result> results;
    private List<Result> searchYear;
    private String date;
    private List<String> years;
    private double temperatuur;

    /**
     * Methode om het CSV file met temperaturen uit te lezen
     * @return list met data
     */
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
                    String year = date.substring(0,4);
                    // krijg temperatuur
                    if(!(lines.length == 1)) {
                        temperatuur = Double.valueOf(lines[1]);
                        // Vul het result in een object en in de list
                        dataset.add(new Result(year, temperatuur));
                    }

                }
            } catch (FileNotFoundException e) {
                System.out.println("Geen file gevonden");
            }
        }
        // kijk nu naar de jaartallen die er dubbel instaan via een andere methode en maak een unieke lijst
        searchYear = filterToUniqueYearsAndAverageTemp(dataset);
        // maak een nieuwe lijst op basis input year van de console
        listBasedOnInputYear(input);

        // keer de lijst terug
        return results;
    }

    /**
     * Methode die de duplicaten jaren eruit haalt en gemiddelde van temp per jaar berekend
     * @param list
     * @return list
     */
    private List<Result> filterToUniqueYearsAndAverageTemp(List<Result> list) {
        filterList = new ArrayList<>();
        // maak een tijdelijk object aan om begin temp te verkrijgen
        Result result = list.get(0);
        double temp = 0;
        int count = 1;

        // loop over de lijst met de startindex en de eerst volgende index
        for(int i = 0; i < list.size(); i ++) {
            for(int j = i + 1; j < list.size(); j++) {
                Result resulti = list.get(i);
                Result resultj = list.get(j);
                // kijk of de jaren hetzelfde zijn
                if(resulti.getYear().equals(resultj.getYear())) {
                    // set de temperatuur en pak het gemiddelde
                    temp += resulti.getTemperature();
                    if(!(resulti.getTemperature() == 0)) {
                        count++;
                    }
                } else { // jaar niet meer gelijk aan elkaar
                    // voeg laatste temp nog toe van het jaar
                    temp += resulti.getTemperature();
                    // maak een tijdelijke lijst aan met de huidige bekende jaartallen in het eind resultaat
                    List<String> currentYears = new ArrayList<>();
                    for(int k = 0; k < filterList.size(); k++) {
                        Result resultk = filterList.get(k);
                        currentYears.add(resultk.getYear());
                    }
                    // bekijk of het jaar niet al bestaat in het eindresultaat
                    if(!currentYears.contains(resulti)) {
                        // voeg een nieuw uniek object toe op jaar basis met het temperatuur
                        filterList.add(new Result(resulti.getYear(), temp / count));
                        // set temp naar een nieuw begin punt namelijk van waar de lijst stop bij j
                        temp = 0;
                        count = 1;
                    }
                }
                break;
            }
        }
        return filterList;
    }

    /**
     * Methode die alleen een lijst maakt van de jaren die je wil
     * @param year van de console input
     * @return de lijst
     */
    public List<Result> listBasedOnInputYear(String year) {
        for(int i = 0; i < searchYear.size(); i++) {
            Result result = searchYear.get(i);
            if(!result.getYear().equals(year)) {
                results.add(result);
            } else {
                results.add(result);
                break;
            }
        }
        return results;
    }

}

