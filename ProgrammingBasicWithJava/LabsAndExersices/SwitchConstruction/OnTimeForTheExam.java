import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hourExam = Integer.parseInt(scanner.nextLine());
        int minutesExam = Integer.parseInt(scanner.nextLine());
        int hourArrive = Integer.parseInt(scanner.nextLine());
        int minutesArrive = Integer.parseInt(scanner.nextLine());
        int totalExamTime = hourExam * 60 + minutesExam;
        int totalArriveTime = hourArrive * 60 +  minutesArrive;
        if (totalArriveTime > totalExamTime) {
            System.out.println("Late");
            int lateMinutes = totalArriveTime - totalExamTime;
            if (lateMinutes < 60){
                System.out.printf("%d minutes after the start", lateMinutes);
            }else {
                int hours = lateMinutes / 60;
                int minutes = lateMinutes % 60;
                System.out.printf("%d:%02d hours after the start", hours, minutes);
            }
        } else if (totalArriveTime == totalExamTime || totalExamTime - totalArriveTime <= 30){
        System.out.println("On time");
        int onTime = totalExamTime - totalArriveTime;
        if ( onTime <= 30 && totalArriveTime!=totalExamTime) {
            System.out.printf("%d minutes before the start", onTime);

        }

        }
        else if (totalExamTime - totalArriveTime > 30){
            System.out.println("Early");
            int earlyMinutes = totalExamTime - totalArriveTime;
            if (earlyMinutes < 60) {
                System.out.printf("%d minutes before the start", earlyMinutes);
            } else {
                int hours = earlyMinutes / 60;
                int minutes = earlyMinutes % 60;
                System.out.printf("%d:%02d hours before the start", hours, minutes);
            }
        }

    }
}
