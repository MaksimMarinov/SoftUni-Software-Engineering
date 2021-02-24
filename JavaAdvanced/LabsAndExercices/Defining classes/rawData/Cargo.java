package rawData;

public class Cargo {
    private int weight;
    private String cargoType;

    public Cargo(int weight, String cargoType) {
        this.weight = weight;
        this.cargoType = cargoType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
}
