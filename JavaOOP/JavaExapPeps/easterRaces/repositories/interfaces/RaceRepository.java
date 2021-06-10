package easterRaces.repositories.interfaces;

import easterRaces.entities.racers.Race;

import java.util.ArrayList;
import java.util.Collection;

public class RaceRepository<T extends Race> implements Repository<T> {
    public Collection<T> models;

    public RaceRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public T getByName(String name) {
        return this.models.stream().filter(race->race.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<T> getAll() {
        return this.models;
    }

    @Override
    public void add(T model) {
        this.models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return this.models.remove(model);
    }
}

