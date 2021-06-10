package vehiclesExtension;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, 1.6, tankCapacity);
    }
    @Override
    public void refuel(double litters){
        if(litters<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if(litters+this.getFuelQuantity()>this.getTankCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(this.getFuelQuantity()+litters*0.95);
    }

}
