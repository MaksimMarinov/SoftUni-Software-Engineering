package GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box<T>{
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return elements;
    }


    public void swapElements(int index1, int index2){
        T firstElement = this.elements.get(index1);
        T secondElement = this.elements.get(index2);
        this.elements.set(index1, secondElement);
        this.elements.set(index2, firstElement);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
       this.elements.forEach(e->output.append(e.getClass().getCanonicalName())
               .append(": ").append(e).append(System.lineSeparator()));
        return output.toString();
    }
}
