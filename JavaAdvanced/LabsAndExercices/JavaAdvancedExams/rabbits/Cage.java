package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void add(Rabbit rabbit){
        if(this.data.size()<capacity){
            this.data.add(rabbit);
        }
    }
    public boolean	removeRabbit(String name){
        return this.data.removeIf(rabbit -> rabbit.getName().equals(name));
    }
    public void removeSpecies(String species){
        this.data.removeAll(this.data.stream().filter(rabbit -> rabbit.getSpecies().equals(species)).collect(Collectors.toList()));
    }
    public Rabbit sellRabbit(String name){
        Rabbit rabbit = this.data.stream().filter(rabbit1 -> rabbit1.getName().equals(name)).findFirst().get();
        rabbit.setAvailable(false);
        return rabbit;
    }
    public List<Rabbit> sellRabbitBySpecies(String species){
       this.data.stream().filter(rabbit -> rabbit.getSpecies().equals(species)).forEach(rabbit -> rabbit.setAvailable(false));
        return  this.data.stream().filter(rabbit -> rabbit.getSpecies().equals(species)).collect(Collectors.toList());
    }
    public int count(){
        return this.data.size();
    }
    public String report(){
        StringBuilder out = new StringBuilder("Rabbits available at ").append(this.name).append(":");
        this.data.stream().filter(Rabbit::isAvailable).forEach(rabbit -> out.append(System.lineSeparator()).append(rabbit));
        return out.toString();

    }
}
