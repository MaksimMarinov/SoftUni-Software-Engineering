import java.util.Scanner;

public class EasterCozonacs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       double budget = Double.parseDouble(scanner.nextLine());
       double flourPrice = Double.parseDouble(scanner.nextLine());
        double pricePerCozonac=flourPrice+(0.25*(1.25*flourPrice))+0.75*flourPrice;
        int countOfCozonacs =0;
        int countOfColouredEggs = 0;
        while (pricePerCozonac<budget){
            countOfCozonacs++;
            budget-=pricePerCozonac;
            countOfColouredEggs+=3;
            if(countOfCozonacs%3==0){
                countOfColouredEggs-=countOfCozonacs-2;
            }

        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", countOfCozonacs, countOfColouredEggs, budget);



    }
}
