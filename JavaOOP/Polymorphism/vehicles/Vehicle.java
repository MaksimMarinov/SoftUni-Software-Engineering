package vehicles;

import java.io.BufferedReader;
import java.text.DecimalFormat;

public class Vehicle implements drivable {
    private double fuelQuantity;
    private double fuelConsumption;
    private double fuelConsumptionIncrease;

    public Vehicle(double fuelQuantity, double fuelConsumption, double fuelConsumptionIncrease) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.fuelConsumptionIncrease=fuelConsumptionIncrease;
    }



    public void setFuelQuantity(double fuelQuantity) {
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
    public void drive(double distance){
        double totalConsumption  = this.getFuelConsumption()+this.fuelConsumptionIncrease;
        if(totalConsumption*distance<=this.getFuelQuantity()){
            this.setFuelQuantity(this.getFuelQuantity()-distance*totalConsumption);
            DecimalFormat dm = new DecimalFormat("#.##");
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), dm.format(distance));
        }else{
            System.out.println(this.getClass().getSimpleName()+" needs refueling");
        }

    }
    public void refuel(double litters){
        this.setFuelQuantity(this.getFuelQuantity()+litters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }

}
