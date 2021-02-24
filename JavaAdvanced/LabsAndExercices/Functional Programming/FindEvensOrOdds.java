import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;


public class FindEvensOrOdds {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        scanner.nextLine();
        String type = scanner.nextLine();
        BiPredicate<String, Integer> findType = (command, number)->{
            if(command.equals("even")){
                return number%2==0;
            }else{
                return number%2!=0;
            }
        };
        IntStream.range(start,end +1).filter(number->findType.test(type, number))
                .forEach(e-> System.out.print(e+" "));

    }
}
