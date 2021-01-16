import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String navigation = scanner.nextLine();
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();
        String current = "";
        while (!navigation.equals("Home")){
        switch (navigation){
            case"forward":

            if(forwardPages.isEmpty()){
                System.out.println("no next URLs");
                navigation= scanner.nextLine();
                continue;
            }else{
                assert current != null;
                history.push(current);
                current=forwardPages.poll();
            }
                break;
            case"back":

                if(history.isEmpty()){
                    System.out.println("no previous URLs");
                    navigation= scanner.nextLine();
                    continue;
                }else{
                    assert current != null;
                    forwardPages.addFirst(current);
                    current=history.pop();
                }
                break;
            default:
                assert current != null;
                if(!current.isEmpty()){
                 history.push(current);
               }
                forwardPages.clear();
                current=navigation;
                break;
        }

            System.out.println(current);
            navigation= scanner.nextLine();
        }

    }
}
