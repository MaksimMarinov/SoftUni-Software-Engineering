import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      int n = Integer.parseInt(scanner.nextLine());
      Map<String, String> carsInfo = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[1];
            switch (tokens[0]){
                case("register"):
                    String number = tokens[2];
                    if(carsInfo.containsKey(name)){
                        System.out.printf("ERROR: already registered with plate number %s%n", carsInfo.get(name));
                    }else{
                        carsInfo.put(name, number);
                        System.out.printf("%s registered %s successfully%n", name, number);
                    }

                    break;
                case("unregister"):
                    if(carsInfo.containsKey(name)){
                        carsInfo.remove(name);
                        System.out.printf("%s unregistered successfully%n",name);
                    }else{
                        System.out.printf("ERROR: user %s not found%n", name);
                    }
                    break;
            }

        }
        carsInfo.forEach((k, v)-> System.out.printf("%s => %s%n", k, v));
    }
}
