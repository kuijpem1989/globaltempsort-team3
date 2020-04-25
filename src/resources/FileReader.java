package resources;

import model.Result;

import java.util.List;

public interface FileReader {

    List<Result> createDataFromFile(String input);

}
