import java.util.ArrayList;

public class CarStorage {
    private ArrayList<Car> listOfCars;

    CarStorage() {
        this.listOfCars = new ArrayList<>();
    }

    public void add(Car car) {
        listOfCars.add(car);
    }

    public void delete(int id) {
        listOfCars.remove(id);
    }

    public ArrayList<Car> getListOfCars() {
        return listOfCars;
    }

    public void setListOfCars(ArrayList<Car> listOfCars) {
        this.listOfCars = listOfCars;
    }

    public String convertToString() {
        StringBuilder builder = new StringBuilder();
        builder.append("-----List of cars-----\n");
        int i = 1;
        for (Car car : listOfCars) {
            builder.append(i).append(") ");
            builder.append(car.toString());
            builder.append("\n");
            i++;
        }
        builder.append("----------------------\n");

        return builder.toString();
    }
}
