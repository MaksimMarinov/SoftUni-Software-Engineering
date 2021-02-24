import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("search")){
            String[] tokens = command.split("-");
            phonebook.put(tokens[0],tokens[1] );
            command= scanner.nextLine();
        }
        command= scanner.nextLine();
        while (!command.equals("stop")){
            if(phonebook.containsKey(command)){
                System.out.printf("%s -> %s%n", command,phonebook.get(command));
            }else{
                System.out.printf("Contact %s does not exist.%n", command);
            }
            command= scanner.nextLine();
        }

    }
}
