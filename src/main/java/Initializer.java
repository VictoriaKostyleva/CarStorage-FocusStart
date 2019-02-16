import java.util.ArrayList;

public class Initializer {
    public void createThreeCars(ArrayList<Car> listOfCars) { // Create three cars for the first launching
        Car car = new Car(2010, "Corolla", "Toyota", "B", "sedan");
        Car car2 = new Car(2005, "x5", "BMV", "C", "hatchback");
        Car car3 = new Car(2011, "Vitara", "Suzuki", "Off-road", "SUV");

        listOfCars.add(car);
        listOfCars.add(car2);
        listOfCars.add(car3);
    }
}
