
    import java.util.Scanner;

    public class Flowers2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int hrizantems = Integer.parseInt(scanner.nextLine());
            int roses = Integer.parseInt(scanner.nextLine());
            int tulips = Integer.parseInt(scanner.nextLine());
            String season = scanner.nextLine();
            String holidayDay = scanner.nextLine();
            double hrizantemsBucket =0;
            double rosesBucket = 0;
            double tulipsBucket = 0;

            double total = 0;
            switch (season){

                case ("Spring"):
                    hrizantemsBucket = hrizantems * 2;
                    rosesBucket = roses * 4.1;
                    tulipsBucket = tulips * 2.5;
                    total = hrizantemsBucket + rosesBucket + tulipsBucket;

                    if (tulips > 7 && tulips+roses+hrizantems<=20) {
                        total = 0.95* total;

                    }else if (tulips+roses+hrizantems > 20 && tulips <=7) {
                        total = 0.8* total;}
                    else if (tulips >7 && tulips+roses+hrizantems > 20){
                        total = 0.8*0.95*total;
                    }break;
                case ("Summer"):
                    hrizantemsBucket = hrizantems * 2;
                    rosesBucket = roses * 4.1;
                    tulipsBucket = tulips * 2.5;
                    total = hrizantemsBucket + rosesBucket + tulipsBucket;
                    if (tulips+roses+hrizantems > 20) {
                        total = 0.8* total;}
                    break;
                case ("Winter"):
                    hrizantemsBucket = hrizantems * 3.75;
                    rosesBucket = roses * 4.5;
                    tulipsBucket = tulips *4.15;
                    total = hrizantemsBucket +  rosesBucket +  tulipsBucket;
                    if (roses >=10 && tulips+roses+hrizantems <=20){
                        total = 0.90* total;

                    }else if (tulips+roses+hrizantems > 20 && roses < 10) {
                        total = 0.8* total;}
                    else if ( roses >=10 && tulips+roses+hrizantems >20){
                        total = 0.8*0.90*total;
                    }break;
                case ("Autumn"):
                    hrizantemsBucket = hrizantems * 3.75;
                    rosesBucket = roses * 4.5;
                    tulipsBucket = tulips * 4.15;
                    total = hrizantemsBucket + rosesBucket + tulipsBucket;
                    if (tulips+roses+hrizantems > 20) {
                        total = 0.8* total;}
                    break;

            }
            if (holidayDay.equals("Y")){
                total = 1.15 * total;}
            else if (holidayDay.equals("N")){
                total = total;


            }System.out.printf("%.2f",total +2);
        }
    }



