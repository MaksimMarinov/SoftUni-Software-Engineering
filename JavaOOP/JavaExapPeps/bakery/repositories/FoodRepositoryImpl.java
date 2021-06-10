package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl <T extends BakedFood> implements FoodRepository<T> {
    private Collection<T> models;

    public FoodRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public T getByName(String name) {
        return this.models.stream().filter(f->f.getName().equals(name)).findFirst().orElse(null);
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
