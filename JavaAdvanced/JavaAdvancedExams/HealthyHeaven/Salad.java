package HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public int getTotalCalories(){
        return  this.products.stream().mapToInt(Vegetable::getCalories).sum();
    }
    public int getProductCount(){
        return this.products.size();
    }
    public void add(Vegetable vegetable){
        this.products.add(vegetable);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("* Salad ").append(this.name).append(" is ").append(this.getTotalCalories())
                .append(" calories and have ").append(this.products.size()).append(" products:");
        this.products.forEach(vegetable->out.append(System.lineSeparator()).append(vegetable));

        return out.toString();
    }
}
