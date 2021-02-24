package GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator<T> {
    public static<T> T[] create(int length, T item) {
       T[] arr = (T[])Array.newInstance(item.getClass(),length);
        Arrays.fill(arr, item);
        return arr;
    }
    public static <T> T[] create(Class<T> tClass, int length, T item) {
        T[] array = (T[]) Array.newInstance(tClass, length);
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }
}

