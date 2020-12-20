import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());
        for (int i =2; i<=number1; i += 2){
            for (int i1 = 2; i1<=number2; i1++){
                for (int i2 =2; i2<=number3; i2 += 2){
                    if (i1 == 2 || i1 == 3|| i1==5 || i1 ==7){
                        System.out.println(i + " "+ i1 + " " + i2);
                        }

                }

            }

            }
        }
    }

