package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish{
    private int size;
    private static final int INCREASE_SIZE = 2;
    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.size=5;

    }

    @Override
    public void eat() {
        int size = super.getSize();
        size += INCREASE_SIZE;
        super.setSize(size);
    }
}

