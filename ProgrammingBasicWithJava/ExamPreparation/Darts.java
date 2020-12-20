import java.util.Scanner;

public class Darts {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String command = scanner.nextLine();
        int shotsSuccess = 0;
        int shotsUnsuccess = 0;
        int pointsLeft = 301;
        int points = 0;
        while (!command.equals("Retire")){


            if (command.equals("Single")){
                command = scanner.nextLine();
                points = Integer.parseInt(command);
                if (pointsLeft<points){
                    shotsUnsuccess++;
                }else{
                    pointsLeft = pointsLeft-points;
                shotsSuccess++;}

            }else if (command.equals("Double")){
                command = scanner.nextLine();
                points = Integer.parseInt(command);
                points = points*2;
                if (pointsLeft<points){
                    shotsUnsuccess++;
                }else{
                    pointsLeft = pointsLeft-points;
                    shotsSuccess++;}}
            else if (command.equals("Triple")){
                command = scanner.nextLine();
                points = Integer.parseInt(command);
                points = points*3;
                if (pointsLeft<points){
                    shotsUnsuccess++;
                }else{
                    pointsLeft = pointsLeft-points;
                    shotsSuccess++;}
                }
            if (pointsLeft==0){
                break;
            }
            command = scanner.nextLine();

            }
        if (pointsLeft==0){
            System.out.printf("%s won the leg with %d shots.", name, shotsSuccess);
        }else {
            System.out.printf("%s retired after %d unsuccessful shots.", name, shotsUnsuccess);

        }
        }
}








