public class Car {
    private int year;
    private String model;
    private String manufacturer;
    private String theClass;
    private String bodyType;

    public Car(int year, String model, String manufacturer, String theClass, String bodyType) {
        this.year = year;
        this.model = model;
        this.manufacturer = manufacturer;
        this.theClass = theClass;
        this.bodyType = bodyType;
    }

    public Car() {}

    public String toString() {
        return "year: " + year + ", model: " + model + ", manufacturer: " + manufacturer + ", class: " +
                theClass + ", body: " + bodyType;
    }

    static Car create() {
        return new Car();
    }

    public Car withYear(String year) {
        if(year != null) {
            setYear(Integer.valueOf(year));
        }
        return this;
    }

    public Car withModel(String model) {
        setModel(model);
        return this;
    }

    public Car withManufacturer(String manufacturer) {
        setManufacturer(manufacturer);
        return this;
    }

    public Car withTheClass(String theClass) {
        setTheClass(theClass);
        return this;
    }

    public Car withBodyType(String bodyType) {
        setBodyType(bodyType);
        return this;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getTheClass() {
        return theClass;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setTheClass(String theClass) {
        this.theClass = theClass;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
}
