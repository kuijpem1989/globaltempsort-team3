package model;

public class Result {

    private String year;
    private double temperature;

    public Result(String year, double temperature) {
        this.year = year;
        this.temperature = temperature;
    }

    public String getYear() {
        return year;
    }

    public double getTemperature() {
        return temperature;
    }

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
