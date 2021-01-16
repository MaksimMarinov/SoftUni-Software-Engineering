import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String navigation = scanner.nextLine();
        ArrayDeque<String> history = new ArrayDeque<>();
        String current = "";
        while (!navigation.equals("Home")){
            if(navigation.equals("back")){
                if(history.isEmpty()){
                    System.out.println("no previous URLs");
                    navigation= scanner.nextLine();
                    continue;
                }else{
                    current=history.pop();


                }
            }else{
                if(!current.isEmpty()){
                    history.push(current);
                }

                current=navigation;


            }
            System.out.println(current);

            navigation= scanner.nextLine();
        }
    }
}
