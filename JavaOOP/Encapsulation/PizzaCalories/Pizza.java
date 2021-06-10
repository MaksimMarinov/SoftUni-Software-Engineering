package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int toppingsCount;

    public Pizza(String name, int toppingsCount) {
        this.setName(name);
        this.setToppings(toppingsCount);
    }

    private void setToppings(int toppingsCount) {
        if (toppingsCount < 0 || toppingsCount > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(toppingsCount);
    }

    private void setName(String name) {
        if(name.trim().isEmpty()||name.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }else{
            this.name=name;
        }

    }
    public double getOverallCalories() {
        return this.dough.calculateCalories()+
                this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }

    public String getName() {
        return name;
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }
    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }
}
