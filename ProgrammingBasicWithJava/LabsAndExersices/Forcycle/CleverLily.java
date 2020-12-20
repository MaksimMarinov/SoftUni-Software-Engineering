import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        double laundry = Double.parseDouble(scanner.nextLine());
        double toyPrice = Double.parseDouble(scanner.nextLine());
        int toys = 0;
        double totalSum = 0;
        double birthdaysMoney = 0;
        double birthdaysMoneyAll = 0;
        int brother = 0;
        for (int i =1; i <= age; i++){
            if (i%2==0) {
                birthdaysMoney += 10;
                birthdaysMoneyAll += birthdaysMoney;
                brother++;
            }else{
                toys += 1;
            } totalSum = birthdaysMoneyAll-brother + toyPrice*toys;


        }double diff = Math.abs(totalSum-laundry);
        if (totalSum>=laundry){
            System.out.printf("Yes! %.2f", diff);
        }else{
            System.out.printf("No! %.2f", diff);

        }

    }
}
