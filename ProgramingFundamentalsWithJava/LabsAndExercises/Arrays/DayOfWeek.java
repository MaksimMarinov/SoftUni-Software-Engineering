import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        int day = new Scanner(System.in).nextInt();
        String[] dayName = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (day>=1&&day<=7){
            System.out.println(dayName[day-1]);
        }else {
            System.out.println("Invalid day!");
                }


            }
        }

