import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getTriangleOfStars(n, true));
        System.out.println(getTriangleOfStars(n, false));
    }
    public static String getTriangleOfStars(int n, boolean isUpwardsOriented){
        StringBuilder out =  new StringBuilder();

        for (int r = 1; r <= n; r++) {
            int spacesCount  = isUpwardsOriented ? n-r :r;
            int starsCount  = isUpwardsOriented ?  r:n-r;
            out.append(repeatString(spacesCount, " "));
            out.append(repeatString(starsCount, "* "));
            if(r!=n){
                out.append(System.lineSeparator());
            }

        }
        return out.toString();
    }
    public static String repeatString(int count, String in){
        StringBuilder out =  new StringBuilder();
        for (int i = 0; i < count; i++) {
            out.append(in);
        }
        return out.toString();
    }
}
