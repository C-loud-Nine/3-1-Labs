
public class Truck implements Vehicle {
    private String model;
    private String make;
    private int year;
    private int capacity;

    public Truck(String model, String make, int year, int capacity) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.capacity = capacity;
    }

    @Override
    public void printInfo() {
        System.out.println("Truck - Model: " + model + ", Make: " + make + ", Year: " + year + ", Capacity: " + capacity);
    }
}
