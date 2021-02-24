package GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return elements;
    }

    public <T extends Comparable> int  countElementsGrater(T element, List<T> elements){
        int count=0;
        for (T t : elements) {
            if (t.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }
}
