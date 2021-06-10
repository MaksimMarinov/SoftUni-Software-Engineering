package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car{
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setCubicCentimeters(cubicCentimeters);
    }

    private void setModel(String model) {
        if(model==null||model.trim().isEmpty()||model.length()<4){
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4 ));
        }
        this.model = model;
    }
    @Override
    public String getModel() {
        return this.model;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    @Override
    public int getHorsePower() {
        return this.horsePower ;
    }

    private void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }


    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.getCubicCentimeters()/this.getHorsePower()*laps;
    }
}
