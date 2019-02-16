public class Main {
    public static void main(String[] args) {
        JSONFileReaderWriter fileRW = new JSONFileReaderWriter();

        CarStorage carStorage = fileRW.readFromFile();

        System.out.println(Constants.helpString);

        ConsoleParser consoleParser = new ConsoleParser(carStorage);

        while (true) {
            if (consoleParser.read()) {
                fileRW.writeToFile(carStorage); //Writes list of cars to the file
                System.out.println(carStorage.convertToString()); // Writes list of cars
            } else {
                System.out.println(Constants.smthIsWrongString);
                System.out.println(Constants.helpString);
            }
        }
    }
}
