
public class Motorcycle implements Vehicle {
    private String model;
    private String make;
    private int year;
    private int capacity;

    public Motorcycle(String model, String make, int year, int capacity) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.capacity = capacity;
    }

    @Override
    public void printInfo() {
        System.out.println("Motorcycle - Model: " + model + ", Make: " + make + ", Year: " + year + ", Capacity: " + capacity);
    }
}
