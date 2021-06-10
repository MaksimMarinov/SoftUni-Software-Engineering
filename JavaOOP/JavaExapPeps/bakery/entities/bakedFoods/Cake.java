package bakery.entities.bakedFoods;

import bakery.entities.bakedFoods.BaseFood;

public class Cake extends BaseFood {
    private final double portion = 245;
    public Cake(String name, double price) {
        super(name, 245,price);
    }
}
