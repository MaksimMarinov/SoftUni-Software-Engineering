package threeuple;

public class Threeuple<K, V, T> {
    private K firstElement;
    private V secondElement;
    private T thirdElement;

    public Threeuple(K firstElement, V secondElement, T thirdElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
        this.thirdElement = thirdElement;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.firstElement, this.secondElement, this.thirdElement);
    }
}
