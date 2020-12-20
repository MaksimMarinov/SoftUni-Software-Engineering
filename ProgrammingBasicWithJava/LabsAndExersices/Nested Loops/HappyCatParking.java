import java.util.Scanner;

public class HappyCatParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());
        //трябва да намерим колко от дните са четни и нечетни и колко от часовете са четни и нечетни.
        int case1=0;
        int case2=0;
        int case3 =0;
        int countDays=0;
        double totalSum = 0;
        double sumPerDay =0;
        for (int i = 1; i<=days; i++){
            double totalSumDay = 0;
            case1=0;
            case2=0;
            case3=0;
            for (int l =1; l<=hours; l++){
            totalSumDay=0;
            if (i%2==0 && l%2==1){
                case1++;
                }else if (i%2==1&& l%2==0){
                    case2++;

                    }else {
                    case3++;


                }totalSumDay=case1*2.5+case2*1.25+case3;


            } totalSum += totalSumDay;
            System.out.printf("Day: %d - %.2f leva%n", i, totalSumDay);


        }
        System.out.printf("Total: %.2f leva", totalSum);
    }
}
