package GenericSwapMethodIntegers;

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


        public List<T> swapElements(int index1, int index2){
            T firstElement = this.elements.get(index1);
            T secondElement = this.elements.get(index2);
            this.elements.set(index1, secondElement);
            this.elements.set(index2, firstElement);
            return this.elements;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (T element : this.elements) {
                sb.append(String.format("%s: %s%n", element.getClass().getCanonicalName(),
                        element));
            }
            return sb.toString();
        }
    }


