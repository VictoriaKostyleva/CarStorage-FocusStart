import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONFileReaderWriter {
    public void writeToFile(CarStorage carStorage) {
        ObjectMapper mapper = new ObjectMapper();

        try (FileOutputStream outputStream = new FileOutputStream(Constants.fileName)) {
            mapper.writeValue(outputStream, carStorage.getListOfCars()); // Write array of cars to file
        } catch (IOException e) {
            Logger.getLogger(JSONFileReaderWriter.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public CarStorage readFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        CarStorage carStorage = new CarStorage();

        if (!isFileExist(Constants.fileName)) { // Initialize file if is doesn't exist

            Initializer initializer = new Initializer();
            initializer.createThreeCars(carStorage.getListOfCars());

            writeToFile(carStorage);
        }

        try (FileInputStream fileStream = new FileInputStream(Constants.fileName)) {
            carStorage.setListOfCars(mapper.readValue(fileStream, new TypeReference<ArrayList<Car>>(){}));

            System.out.println(carStorage.convertToString());

            return carStorage;
        } catch (IOException e) {
            Logger.getLogger(JSONFileReaderWriter.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    private boolean isFileExist(String fileName) { // exist - 1, no - 0
        File file = new File(fileName);
        return file.exists();
    }
}
