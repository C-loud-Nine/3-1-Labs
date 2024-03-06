// VehicleFactory class implementing the Singleton pattern and Factory Method pattern
public class VehicleFactory {
    private static VehicleFactory instance;

    private VehicleFactory() {
        // private constructor to prevent instantiation from outside
    }

    public static synchronized VehicleFactory getInstance() {
        if (instance == null) {
            instance = new VehicleFactory();
        }
        return instance;
    }

    public Vehicle createVehicle(String type, String model, String make, int year, int capacity) {
        switch (type) {
            case "Car":
                return new Car(model, make, year, capacity);
            case "Truck":
                return new Truck(model, make, year, capacity);
            case "Motorcycle":
                return new Motorcycle(model, make, year, capacity);
            default:
                throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
    }
}
