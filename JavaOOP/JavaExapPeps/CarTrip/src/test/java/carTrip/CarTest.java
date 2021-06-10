package carTrip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    Car car;
    double tankCapacity = 100;
    double fuelAmount = 90;
    String model = "Toyota";
    double fuelConsumptionPerKm = 6;

    @Before
    public void setUp() {

        car = new Car(model, tankCapacity, fuelAmount, fuelConsumptionPerKm);
    }

    @Test
    public void testConstructor() {
        assertNotNull(car);
    }

    @Test
    public void testGetModel() {
        assertEquals(car.getModel(), model);
    }

    @Test
    public void testGetTankCapacity() {
        assertEquals(car.getTankCapacity(), tankCapacity, 0.1);
    }

    @Test
    public void testGetFuelAmount() {
        assertEquals(car.getFuelAmount(), fuelAmount, 0.1);
    }

    @Test
    public void testGetFuelConsumption() {
        assertEquals(car.getFuelConsumptionPerKm(), fuelConsumptionPerKm, 0.1);
    }

    @Test
    public void testSetModelWithValid() {
        car.setModel("Trabant");
        assertEquals(car.getModel(), "Trabant");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetModelWithNull() {
        car.setModel(null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetModelWithEmpty() {
        car.setModel("");

    }

    @Test
    public void testSetCapacityWithValid() {
        car.setTankCapacity(99.9);
        assertEquals(car.getTankCapacity(), 99.9, 0.1);
    }

    @Test
    public void testSetFuelAmountlWithValid() {
        car.setFuelAmount(50.1);
        assertEquals(car.getFuelAmount(), 50.1, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFuelAmmountWithMore() {
        car.setFuelAmount(150);

    }

    @Test
    public void testSetFuelConsumptionlWithValid() {
        car.setFuelConsumptionPerKm(5);
        assertEquals(car.getFuelConsumptionPerKm(), 5, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFuelConsumtionWithInvalid() {
        car.setFuelConsumptionPerKm(-1);

    }

    @Test
    public void testDriveValid() {
        double distance = 10;
        String drive = car.drive(distance);
        assertEquals("Have a nice trip", drive);
        assertEquals(car.getFuelAmount(), 30, 0.1);
    }
    @Test(expected = IllegalStateException.class)
    public void testDriveInValid() {
        double distance = 100;
        String drive = car.drive(distance);
        assertEquals(drive, "Cannot travel this distance");

    }
    @Test
    public void testRefuelValid() {
        double fuelAmount = 10;
       car.refuel(fuelAmount);
        assertEquals(car.getFuelAmount(), 100, 0.1);
    }
    @Test(expected = IllegalStateException.class)
    public void testRefuelInValid() {
        double fuelAmount = 100;
        car.refuel(fuelAmount);


    }


}