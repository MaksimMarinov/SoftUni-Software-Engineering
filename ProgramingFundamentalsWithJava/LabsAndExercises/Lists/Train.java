import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        while(!input.equals("end")){
            String[] tokens = input.split("\\s+");
            if(tokens[0].equals("Add")){
                int passengers =  Integer.parseInt(tokens[1]);
                wagons.add(passengers);
            }else{
                int passengers = Integer.parseInt(tokens[0]);
                for (int i = 0; i <wagons.size() ; i++) {
                    int totalPassengers = wagons.get(i) + passengers;
                    if(totalPassengers<=maxCapacity){
                        wagons.set(i, totalPassengers);
                        break;
                    }
                }

            }


            input = scanner.nextLine();
        }
        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");

        }
    }
}
