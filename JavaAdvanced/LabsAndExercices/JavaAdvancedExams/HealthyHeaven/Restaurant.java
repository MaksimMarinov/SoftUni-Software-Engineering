package HealthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data=new ArrayList<>();
    }
    public boolean buy(String name){
        return this.data.removeIf(salad -> salad.getName().equals(name));
    }
    public Salad getHealthiestSalad(){
        return this.data.stream().min(Comparator.comparingInt(Salad::getTotalCalories)).get();
    }
    public void add(Salad salad){
        this.data.add(salad);
    }
    public String generateMenu(){
        StringBuilder out = new StringBuilder(this.name).append(" have ").append(this.data.size()).append(" salads:");
        this.data.forEach(salad -> out.append(System.lineSeparator()).append(salad));
        return out.toString();
    }
}
