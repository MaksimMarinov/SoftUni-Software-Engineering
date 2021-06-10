package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private double price;
    private boolean isReserved;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.price = 0;
        this.isReserved = false;

    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }


    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
        this.isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double billDrinks = this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();
        double billFood = this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
        price = billDrinks+billFood+this.pricePerPerson*numberOfPeople;
        return price;
    }

    @Override
    public void clear() {
        this.drinkOrders.clear();
        this.foodOrders.clear();
        this.isReserved = false;
        this.price=0;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Table: ").append(this.tableNumber).append(System.lineSeparator());
        sb.append("Type: ").append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append("Capacity: ").append(this.capacity).append(System.lineSeparator());
        sb.append("Price per Person: ").append(String.format("%.2f", this.pricePerPerson));
        return sb.toString();
    }
}
