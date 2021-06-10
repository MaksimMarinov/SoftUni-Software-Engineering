

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class ref = Reflection.class;

        Field[] declaredFields = ref.getDeclaredFields();

        Arrays.stream(declaredFields).filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(e-> System.out.println(String.format("%s must be private!",e.getName())));

        Method[] declaredMethods = ref.getDeclaredMethods();

        Arrays.stream(declaredMethods).filter(method -> method.getName().contains("get"))
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> System.out.println(String.format("%s have to be public!",m.getName())));

        Arrays.stream(declaredMethods).filter(method -> method.getName().contains("set"))
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m-> System.out.println(String.format("%s have to be private!",m.getName())));

    }
}