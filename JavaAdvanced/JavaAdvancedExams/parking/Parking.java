package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Car car){
        if(this.data.size()<capacity){
            this.data.add(car);
        }
    }
    public boolean remove(String manufacturer, String model){
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer)&&car.getModel().equals(model));
    }
    public Car getLatestCar(){
        return this.data.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
    }
    public int getCount(){
        return this.data.size();
    }
    public Car getCar(String manufacturer, String model){
        return this.data.stream().filter(car -> car.getManufacturer().equals(manufacturer)&&car.getModel().equals(model))
                .findFirst().orElse(null);
    }
    public String getStatistics(){
        StringBuilder out = new StringBuilder("The cars are parked in ").append(this.type).append(":");
        this.data.forEach(car -> out.append(System.lineSeparator()).append(car));
        return out.toString();
    }


}
