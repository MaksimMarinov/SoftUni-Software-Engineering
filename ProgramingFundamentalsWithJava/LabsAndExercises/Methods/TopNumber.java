import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();
        for (int i = 0; i < input ; i++) {
            if(divideBy8(i)&&oddDigit(i)){
                System.out.println(i);
            }

        }


    }
    public static boolean divideBy8(int input){
        int sum = 0;
        while (input>0){
            sum += input%10;
            input /= 10;

        }if (sum%8==0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean oddDigit(int input){
        int counter = 0;
        while (input>0){
            if ((input%10)%2==1){
                counter++;

            }
            input /= 10;

        }
        if (counter>=1){
            return true;
        }else {
            return false;
        }
    }
}
