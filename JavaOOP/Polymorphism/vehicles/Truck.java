package vehicles;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption, 1.6);
    }
    @Override
    public void refuel(double litters){
        this.setFuelQuantity(this.getFuelQuantity()+litters*0.95);
    }

}
