package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{
    private int size;
    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.size=3;
    }

}