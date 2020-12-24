import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  Integer.parseInt(scanner.nextLine());
        List<String> people = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            if(tokens.length==3){
                if(people.contains(name)){
                    System.out.println(name + " is already in the list!");
                }else{
                    people.add(name);
                }
            }else{
                if(people.contains(name)){
                    people.remove(name);
                }else{
                    System.out.println(name + " is not in the list!");
                }
            }

        }
        for (String person : people) {
            System.out.println(person);

        }

    }
}
