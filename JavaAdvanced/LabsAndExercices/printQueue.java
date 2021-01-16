import java.util.ArrayDeque;
import java.util.Scanner;

public class printQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> commands= new ArrayDeque<>();
        while (!command.equals("print")){
            if(command.equals("cancel")){
                if(commands.isEmpty()){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println("Canceled "+commands.pollFirst());
                }

            }else{
                commands.offer(command);
            }
            command= scanner.nextLine();
        }
       while (!commands.isEmpty()){

           System.out.println(commands.pollFirst());
       }
    }
}
