package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }
    public int count(){
        return this.data.size();
    }
    public void add(Present present){
        if(this.data.size()<capacity){
            this.data.add(present);
        }
    }
    public boolean remove(String name){
        return this.data.removeIf(present -> present.getName().equals(name));
    }
    public Present heaviestPresent(){
        return this.data.stream().max(Comparator.comparingDouble(Present::getWeight)).orElse(null);
    }
    public Present getPresent(String name){
        return this.data.stream().filter(present -> present.getName().equals(name)).findFirst().orElse(null);
    }

    public String report(){
        StringBuilder out = new StringBuilder(this.color).append(" bag contains:");
        this.data.forEach(present -> out.append(System.lineSeparator()).append(present));
        return out.toString();
    }
}
