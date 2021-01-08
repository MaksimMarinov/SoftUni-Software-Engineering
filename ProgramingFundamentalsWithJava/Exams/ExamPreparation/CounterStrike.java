import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy =  Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int count = 0;
        while(!command.equals("End of battle")){
            int distance = Integer.parseInt(command);
            if(energy>=distance){
                energy-=distance;
                count++;
                if(count%3==0){
                    energy+=count;
                }
            }else{
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", count, energy);
                return;
            }

            command=scanner.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d", count, energy);
    }
}
