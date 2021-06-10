package CarShop;

import java.io.Serializable;

public class Seat implements Serializable, Car {
    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

       public Seat(String model, String color, Integer horsePower, String countryProduced) {
            this.setModel(model);
            this.setColor(color);
            this.setHorsePower(horsePower);
            this.setCountryProduced(countryProduced);
        }


    @Override
    public String getModel() {
        return this.model;
    }


    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String getCountryProduced() {
        return this.countryProduced;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", this.model, this.countryProduced, Car.TIRES);
    }
}
