package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IOException,
            IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);
        Method[] methods = blackBoxInt.getClass().getDeclaredMethods();
        while (!"END".equals(line=bf.readLine())){
           String[] tokens = line.split("_");
           String command = tokens[0];
           int value = Integer.parseInt(tokens[1]);
            Method method = Arrays.stream(methods).filter(method1 -> method1.getName().equals(command))
                    .findFirst().get();
            method.setAccessible(true);
           method.invoke(blackBoxInt,value);
            System.out.println(innerValue.getInt(blackBoxInt));
        }




    }
}
