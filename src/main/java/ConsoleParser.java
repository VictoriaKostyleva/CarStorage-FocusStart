import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.exit;

public class ConsoleParser {
    private static HashMap<String, String> flagsMap;
    private CarStorage carStorage;

    private void refreshMap() { // Fills HashMap with nulls
        flagsMap.put(Constants.year, null);
        flagsMap.put(Constants.model, null);
        flagsMap.put(Constants.manufacturer, null);
        flagsMap.put(Constants.theClass, null);
        flagsMap.put(Constants.body, null);
    }

    ConsoleParser (CarStorage carStorage) {
        flagsMap = new HashMap<>();
        this.carStorage = carStorage;
        refreshMap();
    }

    public boolean read() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        // Splitting the string into array of words with space
        ArrayList<String> words = new ArrayList<>(Arrays.asList(inputString.split("\\s")));

        return parseCommand(words);
    }

    private boolean parseCommand (ArrayList<String> words) { // Understand which command it is and process it
        String word0 = words.get(0);
        switch (word0) {
            case Constants.add:
                return add(words);
            case Constants.change:
                return change(words);
            case Constants.delete:
                return delete(words);
            case Constants.help:
                System.out.println(Constants.moreInformationString);
                return true;
            case Constants.exit:
                exit(0);
            default:
                return false;
        }
    }

    private boolean delete(ArrayList<String> words) {
        if (words.size() == 2 && isNumber(words.get(1))) {
            int id = Integer.valueOf(words.get(1)) - 1;
            if (!isIndexOutOfRange(id)) {
                carStorage.delete(id);
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean add(ArrayList<String> words) {
        if (!parseFlags(words)) {
            return false;
        }

        ArrayList<String> valuesList = new ArrayList<>(flagsMap.values());

        for(String i : valuesList) {
            if (i!= null) {
                //code here
                carStorage.add(Car.create()
                        .withYear(flagsMap.get(Constants.year))
                        .withModel(flagsMap.get(Constants.model))
                        .withTheClass(flagsMap.get(Constants.theClass))
                        .withBodyType(flagsMap.get(Constants.body))
                        .withManufacturer(flagsMap.get(Constants.manufacturer)));
                refreshMap();
                return true;
            }
        }
        return false;

    }

    private boolean change (ArrayList<String> words) {
        if (isNumber(words.get(1))) {
            int index = Integer.valueOf(words.get(1)) - 1;
            if (!isIndexOutOfRange(index)) {
                words.remove(1);
                if (!parseFlags(words)) {
                    return false;
                }
                changeCar(index);
                refreshMap();
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean parseFlags (ArrayList<String> words) { // Parsing flags (odd - flag, even - value)
        for (int i = 1; i <= words.size() - 1; i += 2) {
            if (flagsMap.containsKey(words.get(i)) ) {
                if (i < words.size() - 1) {
                    flagsMap.put(words.get(i), words.get(i + 1));
                }
            } else {
                refreshMap();
                return false;
            }
        }

        return checkIfYearIsNumber();
   }

   private boolean checkIfYearIsNumber() {
       return flagsMap.get(Constants.year) == null || isNumber(flagsMap.get(Constants.year));
   }

    private static boolean isNumber (String str) {
        try {
            double i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isIndexOutOfRange (int index) {
        return index >= carStorage.getListOfCars().size();
    }

    private void changeCar(int index) {
        Car carToChange = carStorage.getListOfCars().get(index);// Getting the element that should be changed

        if (flagsMap.get(Constants.year) != null) {
            carToChange.setYear(Integer.valueOf(flagsMap.get(Constants.year)));
        }

        if (flagsMap.get(Constants.model) != null) {
            carToChange.setModel(flagsMap.get(Constants.model));
        }

        if (flagsMap.get(Constants.theClass) != null) {
            carToChange.setTheClass(flagsMap.get(Constants.theClass));
        }

        if (flagsMap.get(Constants.body) != null) {
            carToChange.setBodyType(flagsMap.get(Constants.body));
        }

        if (flagsMap.get(Constants.manufacturer) != null) {
            carToChange.setManufacturer(flagsMap.get(Constants.manufacturer));
        }
    }
}
