public class Main {
    public static void main(String[] args) {
        // Get an instance of the VehicleFactory
        VehicleFactory vehicleFactory = VehicleFactory.getInstance();

        // Create vehicles using the factory method
        Vehicle car = vehicleFactory.createVehicle("Car", "SUV", "Toyota", 2020, 5);
        Vehicle truck = vehicleFactory.createVehicle("Truck", "XL", "Ford", 2018, 3);
        Vehicle motorcycle = vehicleFactory.createVehicle("Motorcycle", "Cruiser", "Harley-Davidson", 2019, 1);

        // Print vehicle information
        car.printInfo();
        truck.printInfo();
        motorcycle.printInfo();

        // Trying to create an invalid vehicle type
        try {
            Vehicle invalidVehicle = vehicleFactory.createVehicle("InvalidType", "Invalid", "Invalid", 2022, 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
