import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class VehicleFactoryTest {

    @Test
    public void testCreateCar() {
        VehicleFactory vehicleFactory = VehicleFactory.getInstance();
        Vehicle car = vehicleFactory.createVehicle("Car", "SUV", "Toyota", 2020, 5);
        assertNotNull(car);
        assertTrue(car instanceof Car);
    }

    @Test
    public void testCreateTruck() {
        VehicleFactory vehicleFactory = VehicleFactory.getInstance();
        Vehicle truck = vehicleFactory.createVehicle("Truck", "XL", "Ford", 2018, 3);
        assertNotNull(truck);
        assertTrue(truck instanceof Truck);
    }

    @Test
    public void testCreateMotorcycle() {
        VehicleFactory vehicleFactory = VehicleFactory.getInstance();
        Vehicle motorcycle = vehicleFactory.createVehicle("Motorcycle", "Cruiser", "Harley-Davidson", 2019, 1);
        assertNotNull(motorcycle);
        assertTrue(motorcycle instanceof Motorcycle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateInvalidVehicle() {
        VehicleFactory vehicleFactory = VehicleFactory.getInstance();
        Vehicle invalidVehicle = vehicleFactory.createVehicle("InvalidType", "Invalid", "Invalid", 2022, 0);
        fail("Expected IllegalArgumentException was not thrown.");
    }
}
