import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resourcesInfo = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());
            resourcesInfo.putIfAbsent(command,0);
            resourcesInfo.put(command, quantity+resourcesInfo.get(command));
            command= scanner.nextLine();
        }
        resourcesInfo.forEach((k,v)->{
            System.out.println(k+" -> "+ v);
        });

    }
}
