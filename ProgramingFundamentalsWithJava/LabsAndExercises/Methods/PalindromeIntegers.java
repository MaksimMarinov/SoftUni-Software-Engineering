import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while(!command.equals("END")){
            String[] arrayForward = command.split("");
            String[] arrayBackward = new String[command.length()];
            int j = command.length();
            for (int i =0 ; i <command.length() ; i++) {

                arrayBackward[j-1] = arrayForward[i];
                j=j-1;

            }
            boolean isEqual = false;
            for (int i = 0; i < arrayForward.length; i++) {
                if(arrayForward[i].equals(arrayBackward[i])){
                    isEqual=true;
                }else{
                    isEqual=false;
                }

            }
            if(isEqual){
                System.out.println(true);
            }else{
                System.out.println(false);
            }




            command = scanner.nextLine();
        }
    }
}