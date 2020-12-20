import java.util.Scanner;

public class hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int period = Integer.parseInt(scanner.nextLine());
        int doctors = 7;
        int sumCuredPacients =  0;
        int sumUnCuredPacients =  0;
        for(int i = 1; i<=period; i++){
            int pacients = Integer.parseInt(scanner.nextLine());
            if (i%3==0){
                if (sumCuredPacients<sumUnCuredPacients){
                    doctors=doctors+1;
                }


            }
               if (doctors>=pacients){
                   int curedPacients = pacients;
            sumCuredPacients += curedPacients;
                   int unCuredPacients = pacients - curedPacients;

                   sumUnCuredPacients += unCuredPacients;}
               if (doctors<pacients){
                  int curedPacients = doctors;
                   sumCuredPacients += curedPacients;
                   int unCuredPacients = pacients - curedPacients;

                   sumUnCuredPacients += unCuredPacients;}






        }
        System.out.printf("Treated patients: %s.%n", sumCuredPacients);
        System.out.printf("Untreated patients: %s.", sumUnCuredPacients);
    }
}
