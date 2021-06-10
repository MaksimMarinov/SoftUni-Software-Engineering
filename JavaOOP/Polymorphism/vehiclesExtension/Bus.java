package vehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    private boolean isEmpty;
    public Bus(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption, 0, tankCapacity);
        this.isEmpty=true;

    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }


    @Override
    public String drive(double distance){

        if(!this.isEmpty){
            this.setFuelConsumption(this.getFuelConsumption()+1.4);
        }
        DecimalFormat dm = new DecimalFormat("#.##");
        if(this.getFuelConsumption()*distance<=this.getFuelQuantity()){
            this.setFuelQuantity(this.getFuelQuantity()-this.getFuelConsumption()*distance);
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), dm.format(distance));
        }else{
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }

    }

}
