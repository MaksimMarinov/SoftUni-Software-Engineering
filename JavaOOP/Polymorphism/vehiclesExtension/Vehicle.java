package vehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle implements Drivable {
    private double fuelQuantity;
    private double fuelConsumption;
    private double fuelConsumptionIncrease;
    private double tankCapacity;



    public Vehicle(double fuelQuantity, double fuelConsumption, double fuelConsumptionIncrease, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.fuelConsumptionIncrease=fuelConsumptionIncrease;
        this.tankCapacity=tankCapacity;
    }

    public double getFuelConsumptionIncrease() {
        return fuelConsumptionIncrease;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if(fuelQuantity<0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    @Override
    public String drive(double distance){
        double totalConsumption  = this.getFuelConsumption()+this.fuelConsumptionIncrease;
        if(totalConsumption*distance<=this.getFuelQuantity()){
            this.setFuelQuantity(this.getFuelQuantity()-distance*totalConsumption);
            DecimalFormat dm = new DecimalFormat("#.##");
         return String.format("%s travelled %s km", this.getClass().getSimpleName(), dm.format(distance));
        }else{
           return String.format("%s needs refueling", this.getClass().getSimpleName());
        }

    }
    public void refuel(double litters){
        if(litters<=0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if(litters+this.getFuelQuantity()>this.tankCapacity){
         throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(this.getFuelQuantity()+litters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }

}
