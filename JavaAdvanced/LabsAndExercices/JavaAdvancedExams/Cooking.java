import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Cooking {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(liquids::offer);
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(ingredients::push);
        Map<String, Integer> food = new HashMap<String, Integer>();
        food.put("Bread: ", 0);
        food.put("Cake: ", 0);
        food.put("Fruit Pie: ", 0);
        food.put("Pastry: ",0);

        while (!liquids.isEmpty()&&!ingredients.isEmpty()){
        int currentLiquid = liquids.poll();
        int currentIngredient = ingredients.pop();
        int sum = currentIngredient+currentLiquid;
        if(sum==25){
            food.put("Bread: ", food.get("Bread: ")+1);
        }else if(sum==50){
            food.put("Cake: ", food.get("Cake: ")+1);
        }else if(sum==100){
            food.put("Fruit Pie: ",food.get("Fruit Pie: ")+1);
        }else if(sum==75){
            food.put("Pastry: ", food.get("Pastry: ")+1);
        }else{
            ingredients.push(currentIngredient+3);
        }
        }
        if(food.get("Fruit Pie: ")!=0&&food.get("Pastry: ")!=0&&food.get("Cake: ")!=0&&food.get("Bread: ")!=0){
            System.out.println("Wohoo! You succeeded in cooking all the food!" );
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything." );
        }
       if(liquids.isEmpty()){
           System.out.println("Liquids left: none");
       }else{
           System.out.print("Liquids left: ");
           printProductLeft(liquids);
       }
       if(ingredients.isEmpty()){
           System.out.println("Ingredients left: none");
       }else{
           System.out.print(("Ingredients left: "));
           printProductLeft(ingredients);
       }
       food.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e-> System.out.println(e.getKey()+e.getValue()));


    }

    private static void printProductLeft(ArrayDeque<Integer> liquids) {
        List<String> out = liquids.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.print(String.join(", ", out));
        System.out.println();
    }
}
