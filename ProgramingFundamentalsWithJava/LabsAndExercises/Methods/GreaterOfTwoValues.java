import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
       if (input.equals("int")) {
           int n1 = Integer.parseInt(scanner.nextLine());
           int n2 = Integer.parseInt(scanner.nextLine());
           System.out.println(getMax(n1, n2));
       }
           else if(input.equals("char")) {
           char c1 = scanner.nextLine().charAt(0);
           char c2 = scanner.nextLine().charAt(0);
           System.out.println(getMax(c1, c2));
       }
           else if(input.equals("String".toLowerCase())){
               String first = scanner.nextLine();
               String second = scanner.nextLine();
               System.out.println(getMax(first,second));}



       }



    private static String getMax(String first, String second) {
        if(first.compareTo(second)>=0) {
            return first;

        }return second;
    }


    private static int getMax(int n1, int n2) {
        return (int)Math.max(n1, n2);
    }
    private static char getMax(char c1, char c2) {
        return (char) Math.max(c1, c2);

    }
}
