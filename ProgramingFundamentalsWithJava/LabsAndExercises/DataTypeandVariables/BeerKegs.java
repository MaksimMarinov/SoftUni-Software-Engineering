import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String biggestKeg = "";
        double biggestVolume = 0;
        for (int i = 1; i <=n ; i++) {
            String nameKeg = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());;
            int height = Integer.parseInt(scanner.nextLine());
            double currentVolume = Math.PI*(Math.pow(radius, 2))*height;
            if (currentVolume>biggestVolume){
                biggestKeg=nameKeg;
                biggestVolume=currentVolume;
            }


        }
        System.out.println(biggestKeg);

    }
}
