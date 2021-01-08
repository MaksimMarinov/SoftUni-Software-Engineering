import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HelloFrance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\|+")).collect(Collectors.toList());
        double budget = Double.parseDouble(scanner.nextLine());
        List<Double> newList = new ArrayList<>();
        double totalSum =0;
        double profit=0.0;
        for (int i = 0; i <numbers.size() ; i++) {
            String[] tokens = numbers.get(i).split("->");
            double rate = Double.parseDouble(tokens[1]);
           if(checkIfItIsInRange(tokens)){
               if(budget-rate>=0){
            newList.add(rate*1.4);
            budget-=rate;
            profit+=(rate*0.4);
            totalSum+=(rate*1.4);
               }
           }
        }
        for (Double aDouble : newList) {
            System.out.printf("%.2f ",aDouble);
        }
        System.out.printf("%nProfit: %.2f%n",profit);
        if((totalSum+budget)>=150){
            System.out.println("Hello, France!");

        }else{
            System.out.println("Time to go.");
        }



    }

    private static boolean checkIfItIsInRange(String []token) {
        double rate = Double.parseDouble(token[1]);
        switch (token[0]){
            case("Clothes"):
                if(rate<=50)
                    return true;
                break;
            case("Shoes"):
                if(rate<=35)
                    return true;
                break;
            case("Accessories"):
                if(rate<=20.5)
                    return true;
                break;
        }
        return false;


    }
}
