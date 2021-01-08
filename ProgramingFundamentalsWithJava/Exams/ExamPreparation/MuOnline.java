import java.sql.SQLOutput;
import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] line= scanner.nextLine().split("\\|+");
        int health =100;


        int bitcoins = 0;
        int countRooms=0;
        for (int i = 0; i < line.length; i++) {
            String[] command = line[i].split("\\s+");
            countRooms++;
            int power= Integer.parseInt(command[1]);
            switch (command[0]){
                case ("potion"):
                if(health+power<=100){
                   health+=power;
                    System.out.printf("You healed for %d hp.%n", power);
                    System.out.printf("Current health: %d hp.%n", health);

                }else if(health+power>100){
                    power=100-health;
                    health=100;
                    System.out.printf("You healed for %d hp.%n", power);
                    System.out.printf("Current health: %d hp.%n", health);
                }
                break;
            case("chest"):
                bitcoins+=power;
                System.out.printf("You found %d bitcoins.%n", power);
                break;
            default:
                health-=power;
                if(health>0){
                    System.out.printf("You slayed %s.%n", command[0]);
                }else{
                    System.out.printf("You died! Killed by %s.%n",command[0]);
                    System.out.printf("Best room: %d", countRooms);
                    return;
                }
                break;

            }
        }
        System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", bitcoins, health);

    }



}
