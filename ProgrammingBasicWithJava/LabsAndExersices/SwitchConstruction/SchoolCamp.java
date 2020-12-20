import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        String kind = scanner.nextLine();
        int students = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double total = 0;
        String sport = "";
        switch (season){
            case ("Spring"):
                if (kind.equals("boys")){
                    total = 7.2 * students*nights;
                sport = "Tennis";
                } else if (kind.equals("girls")){
                    total = 7.2 * students*nights;
                    sport = "Athletics";

                }else if (kind.equals("mixed")){
                total = 9.5 * students*nights;
                sport = "Cycling";
                }break;
            case ("Winter"):
                if (kind.equals("boys")){
                    total = 9.6 * students*nights;
                    sport = "Judo";
                } else if (kind.equals("girls")){
                    total = 9.6 * students*nights;
                    sport = "Gymnastics";

                }else if (kind.equals("mixed")){
                    total = 10 * students*nights;
                    sport = "Ski";
                }break;
            case ("Summer"):
                if (kind.equals("boys")){
                    total = 15 * students*nights;
                    sport = "Football";
                } else if (kind.equals("girls")){
                    total = 15 * students*nights;
                    sport = "Volleyball";

                }else if (kind.equals("mixed")){
                    total = 20 * students*nights;
                    sport = "Swimming";
                }break;
        }if (students >= 50){
            total = total*0.5;
        }else if (students<50 && students>=20){
            total = total*0.85;
        }else if (students<20 && students>=10){
            total = 0.95*total;
        }
        System.out.printf("%s %.2f lv.", sport, total);

    }
}
