package aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium{
    private static final int initialCapacity = 25;
    public SaltwaterAquarium(String name) {
        super(name, initialCapacity);
    }
}
