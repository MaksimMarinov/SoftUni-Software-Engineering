import java.util.Scanner;

public class SumPrimNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command =  scanner.nextLine();
        int sumPrimeNumbers = 0;
        int sumNoPrime = 0;
        while (!command.equals("stop")){
            int number = Integer.parseInt(command);
            int count =0;
            if (number<0){
                System.out.println("Number is negative.");
            }
            for (int i = 1; i <=number; i++){
                if (number%i==0){
                    count++;
                }

            }
            if (count ==2){
                sumPrimeNumbers += number;

            }else if (count>2){
                sumNoPrime += number;

            }
            command = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", sumPrimeNumbers);
        System.out.printf("Sum of all non prime numbers is: %d", sumNoPrime);
    }
}
