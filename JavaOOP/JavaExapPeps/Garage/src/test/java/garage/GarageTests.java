package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GarageTests {
    private Car car;
    private final String brand = "Toyota";
    private final int maxSpeed = 150;
    private final double price = 15000;
    private Garage garage;
    @Before
    public void setUp() {
        car = new Car(brand, maxSpeed, price);
        garage = new Garage();
    }
    @Test
    public void testConstructor(){
        assertNotNull(garage);
    }
    @Test
    public void testAddWithValid(){
        garage.addCar(car);
        assertEquals("Toyota", garage.getCars().get(0).getBrand());
        assertEquals(1, garage.getCars().size());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testWithInvalid(){
        garage.addCar(null);
    }
    @Test
    public void testGetCount(){
        garage.addCar(car);
        assertEquals(1, garage.getCount());
    }
    @Test
    public void testFindAllCarsWithMaxSpeedAbove(){
        garage.addCar(new Car("Ferrari", 200, 2000000));
        garage.addCar(new Car("Lambo", 250, 2000000));
        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(199);
        assertEquals(2, allCarsWithMaxSpeedAbove.size());
        assertEquals("Ferrari", allCarsWithMaxSpeedAbove.get(0).getBrand());
        assertEquals(200, allCarsWithMaxSpeedAbove.get(0).getMaxSpeed());
        assertEquals(2000000, allCarsWithMaxSpeedAbove.get(0).getPrice(),0.1);
    }
    @Test
    public void testGetTheMostExpensiveCar(){
        garage.addCar(new Car("Ferrari", 200, 2600000));
        garage.addCar(new Car("Lambo", 250, 2000000));
        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();
        assertEquals("Ferrari", theMostExpensiveCar.getBrand());
        assertEquals(200, theMostExpensiveCar.getMaxSpeed());
        assertEquals(2600000, theMostExpensiveCar.getPrice(),0.1);
    }
    @Test
    public void testGetEqualBrand(){

        garage.addCar(new Car("Lambo", 250, 2000000));
        garage.addCar(new Car("Lambo", 200, 2600000));
        List<Car> toyota = garage.findAllCarsByBrand("Lambo");
        assertEquals(2, toyota.size());
        assertEquals("Lambo", toyota.get(0).getBrand());
        assertEquals(200, toyota.get(1).getMaxSpeed());
    }


}