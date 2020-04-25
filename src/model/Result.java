package model;

/**
 * Result model class
 * @author michaelkuijpers, dennisparagusha, abdulahouali
 */
public class Result {

    // Class variabelen
    private String year;
    private double temperature;

    // Contructor
    public Result(String year, double temperature) {
        this.year = year;
        this.temperature = temperature;
    }

    // Getters
    public String getYear() {
        return year;
    }

    public double getTemperature() {
        return temperature;
    }

    // Compared temperaturen met elkaar
    public int compareTo(Result result) {
        if (this.temperature < result.temperature) {
            return -1;
        } else if (this.temperature > result.temperature) {
            return 1;
        } else {
            return 0;
        }
    }
}
