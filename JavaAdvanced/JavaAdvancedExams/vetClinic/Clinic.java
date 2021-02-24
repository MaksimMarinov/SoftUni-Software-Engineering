package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    public void add(Pet pet){
        if(this.data.size()<capacity){
            this.data.add(pet);
        }
    }
    public boolean remove(String name){
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }
    public Pet getPet(String name, String owner){
        return this.data.stream().filter(pet -> pet.getName().equals(name)&&pet.getOwner().equals(owner))
                .findFirst().orElse(null);
    }
    public Pet getOldestPet(){
        return  this.data.stream().max(Comparator.comparingInt(Pet::getAge)).get();
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder out = new StringBuilder("The clinic has the following patients:");
        this.data.forEach(pet -> out.append(System.lineSeparator()).append(pet.getName()).append(" ").append(pet.getOwner()));
        return out.toString();
    }
}
