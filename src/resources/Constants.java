package resources;

public class Constants {

    // De finals
    private final static String FILE_PATH = "src/resources/files/globaltemperatures.csv";
    private final static String REGEX_KOMMA = ",";

    // Getters
    public static String getFilePath() {
        return FILE_PATH;
    }

    public static String getRegexKomma() {
        return REGEX_KOMMA;
    }
}
