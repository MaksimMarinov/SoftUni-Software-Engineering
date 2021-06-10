package bakery.repositories;

import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;

public class DrinkRepositoryImpl<T extends Drink> implements DrinkRepository<T> {
    private Collection<T> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public T getByNameAndBrand(String drinkName, String drinkBrand) {
        return this.models.stream().filter(d -> d.getName().equals(drinkName) && d.getBrand().equals(drinkBrand)).findFirst().orElse(null);
    }

    @Override
    public Collection<T> getAll() {
        return this.models;
    }

    @Override
    public void add(T t) {
        this.models.add(t);
    }
}