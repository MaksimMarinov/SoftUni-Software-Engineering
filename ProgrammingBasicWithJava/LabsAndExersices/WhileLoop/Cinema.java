import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hall = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int cinemaIncome = 0;
        int peopleNum = 0;
        while (!command.equals("Movie time!")){
            int num = Integer.parseInt(command);
            peopleNum += num;
            if (peopleNum>hall) {
                break;}
            if (num%3==0) {
                cinemaIncome += num * 5 - 5;
            }else{
                cinemaIncome += num*5;
            }

            command = scanner.nextLine();


        }if (command.equals("Movie time!")){
            System.out.printf("There are %d seats left in the cinema.%n", hall-peopleNum);
        }if (peopleNum>hall) {
            System.out.println("The cinema is full.");
        }
        System.out.printf("Cinema income - %d lv.", cinemaIncome);

    }
}
