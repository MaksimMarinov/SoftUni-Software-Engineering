package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] pizzaTokens = readArray(bf);
        Pizza pizza = new Pizza(pizzaTokens[1], Integer.parseInt(pizzaTokens[2]) );
        String[] doughTokens = readArray(bf);
        Dough dough = new Dough(doughTokens[1], doughTokens[2],Double.parseDouble(doughTokens[3]));
        pizza.setDough(dough);
        for (int i = 0; i < Integer.parseInt(pizzaTokens[2]); i++) {
            String[] toppingTokens = readArray(bf);
            Topping topping = new Topping(toppingTokens[1], Double.parseDouble(toppingTokens[2]));
            pizza.addTopping(topping);
        }
        System.out.printf("%s - %.2f",pizza.getName(),pizza.getOverallCalories());



    }
    private static String[] readArray(BufferedReader bf) throws IOException {
        return bf.readLine().split("\\s+");
    }
}
