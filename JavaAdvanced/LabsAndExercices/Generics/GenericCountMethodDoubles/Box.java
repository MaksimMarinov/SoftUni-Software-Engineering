package GenericCountMethodDoubles;

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

    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    public <T extends Comparable> int countElementsGrater(T element, List<T> elements) {
        int count = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

}
