import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class bombs {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> effects = new ArrayDeque<>();
        Arrays.stream(bf.readLine().split(", ")).mapToInt(Integer::parseInt).forEach(effects::offer);
        ArrayDeque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(bf.readLine().split(", ")).mapToInt(Integer::parseInt).forEach(casings::push);
        Map<String, Integer> bombs = new HashMap<>();
        bombs.put("Cherry Bombs: ", 0);
        bombs.put("Datura Bombs: ", 0);
        bombs.put("Smoke Decoy Bombs: ", 0);
        while (!effects.isEmpty()&&!casings.isEmpty()&&!isAllBombCompleted(bombs)){
            int currentEffect = effects.peek();
            int currentCasing = casings.pop();
            int sum = currentCasing+currentEffect;
            if(sum==40){
                effects.poll();
                bombs.put("Datura Bombs: ", bombs.get("Datura Bombs: ")+1);
            }else if(sum==60){
                effects.poll();
                bombs.put("Cherry Bombs: ", bombs.get("Cherry Bombs: ")+1 );
            }else if(sum==120){
                effects.poll();
              bombs.put("Smoke Decoy Bombs: ", bombs.get("Smoke Decoy Bombs: ")+1);
            }else{
                casings.push(currentCasing-5);
            }
        }
        if(isAllBombCompleted(bombs)){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else{
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }String out = "Bomb Effects: ";
        print(effects, out);
        out = "Bomb Casings: ";
        print(casings, out);
        bombs.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(bomb-> System.out.println(bomb.getKey()+bomb.getValue()));


    }

    private static void print(ArrayDeque<Integer> products, String out) {
        if (products.isEmpty()) {
            System.out.println(out + "empty");
        } else {
            List<String> print = products.stream().map(String::valueOf).collect(Collectors.toList());
            out += String.join(", ",print);
            System.out.println(out);
        }
    }

    private static boolean isAllBombCompleted(Map<String, Integer> bombs){
        for (Integer value : bombs.values()) {
            if(value<3){
                return false;
            }
        }
        return true;
    }
}
