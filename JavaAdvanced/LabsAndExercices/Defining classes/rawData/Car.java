package rawData;

import java.util.Arrays;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tiers;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tiers) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tiers = tiers;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tire[] getTiers() {
        return tiers;
    }

    public void setTiers(Tire[] tiers) {
        this.tiers = tiers;
    }

    @Override
    public String toString() {
        return String.format("%s", this.model);
    }
}
