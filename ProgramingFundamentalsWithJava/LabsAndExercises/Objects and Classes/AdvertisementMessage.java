import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        String[] phrases = {"Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."};
        String[] events =  {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. ",
                "I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int randomPhraseNum = rnd.nextInt(phrases.length);
            int randomEventsNum = rnd.nextInt(phrases.length);
            int randomAuthorsNum = rnd.nextInt(phrases.length);
            int randomCitiesNum = rnd.nextInt(phrases.length);
            System.out.println(String.join(" ",phrases[randomPhraseNum] + " " + events[randomEventsNum])
                    +" " +authors[randomAuthorsNum] + " "+cities[randomCitiesNum] );


        }



        

    }

}
