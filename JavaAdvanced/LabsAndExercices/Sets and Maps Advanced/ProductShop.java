import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> storeInfo = new TreeMap<>();
        String command = scanner.nextLine();
        while (!command.equals("Revision")){
            String[] tokens = command.split(", ");
            storeInfo.putIfAbsent(tokens[0], new LinkedHashMap<>());
            storeInfo.get(tokens[0]).putIfAbsent(tokens[1], Double.parseDouble(tokens[2]) );

            command= scanner.nextLine();
        }

        storeInfo.entrySet().forEach(store->{
            System.out.printf("%s->%n", store.getKey());
            store.getValue().entrySet().forEach(product->{
                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
            });
        });
    }
}
