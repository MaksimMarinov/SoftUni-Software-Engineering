package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Car> cars;
    private Repository<Driver> drivers;
    private Repository<Race> races;

    public ControllerImpl( Repository<Driver> drivers,Repository<Car> cars, Repository<Race> races) {
        this.cars = cars;
        this.drivers = drivers;
        this.races = races;
    }

    @Override
    public String createDriver(String driver) {
        if(drivers.getByName(driver)!=null){
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }
        Driver racer = new DriverImpl(driver);

        drivers.add(racer);
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if (this.cars.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }
        Car car = null;
        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        }
        cars.add(car);
        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (this.drivers.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        if (cars.getByName(carModel) == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }
        Driver driver = drivers.getByName(driverName);
        Car car = cars.getByName(carModel);
        driver.addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if(races.getByName(raceName)==null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (drivers.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        Driver driver = drivers.getByName(driverName);
        Race race = races.getByName(raceName);
        race.addDriver(driver);

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        if(races.getByName(raceName)==null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }
    Race race = races.getByName(raceName);
        int laps = race.getLaps();
    List<Driver> sortedDrivers = drivers.getAll().stream().filter(Driver::getCanParticipate).sorted((a, b)-> Double.compare(b.getCar()
            .calculateRacePoints(laps), a.getCar().calculateRacePoints(laps))).collect(Collectors.toList());
    if(sortedDrivers.size()<3){
        throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
    }
    StringBuilder out = new StringBuilder();
    Driver first = sortedDrivers.get(0);
    first.winRace();
    out.append(String.format(DRIVER_FIRST_POSITION, first.getName(), raceName)).append(System.lineSeparator());
    Driver second = sortedDrivers.get(1);
        out.append(String.format(DRIVER_SECOND_POSITION, second.getName(), raceName)).append(System.lineSeparator());
    Driver third = sortedDrivers.get(2);
        out.append(String.format(DRIVER_THIRD_POSITION, third.getName(), raceName));

        return out.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        if(races.getByName(name)!=null){
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }
Race race = new RaceImpl(name, laps);
        races.add(race);
        return String.format(RACE_CREATED, name);
    }
}
