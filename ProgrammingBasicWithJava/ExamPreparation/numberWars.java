import java.util.Scanner;

public class numberWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();
        String name2= scanner.nextLine();
        String command = "";
        int card1 = 0;
        int card2 =0;
        int diff1 = 0;
        int diff2 = 0;
        while (true){
            command = scanner.nextLine();
            if (command.equals("End of game")){
                System.out.printf("%s has %d points%n", name1, diff1);
                System.out.printf("%s has %d points", name2, diff2);
                break;

            }card1= Integer.parseInt(command);

            command = scanner.nextLine();
            card2= Integer.parseInt(command);
            if (card1>card2){
                diff1 += card1-card2;

            }else if (card2>card1){
                diff2 += card2-card1;
            }else {
                System.out.println("Number wars!");
                command = scanner.nextLine();
                card1= Integer.parseInt(command);
                command = scanner.nextLine();
                card2= Integer.parseInt(command);

                if (card1>card2){

                    System.out.printf("%s is winner with %d points", name1, diff1);

                }else if (card2>card1){
                    System.out.printf("%s is winner with %d points", name2, diff2);

                }
                break;

            }
        }


    }

}
