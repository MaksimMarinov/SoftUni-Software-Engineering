import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String[] words = scanner.nextLine().split("\\s+");

        Random rnd = new Random(0);
        for (int i = 0; i < words.length; i++) {

            int randomIndex1= rnd.nextInt(words.length);
            int x= rnd.nextInt(words.length);
            String word =words[x];
            words[x]= words[randomIndex1];
        words[randomIndex1]=word;}
        System.out.println(String.join(System.lineSeparator(),words));

    }


}
