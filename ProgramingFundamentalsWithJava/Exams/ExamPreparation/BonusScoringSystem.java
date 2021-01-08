import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countStudents = Integer.parseInt(scanner.nextLine());
        int countLectures = Integer.parseInt(scanner.nextLine());
        int initialBonus = Integer.parseInt(scanner.nextLine());
        int maxLectures = 0;
        double totalBonus=0;
        double maxBonus=0;
        for (int i = 0; i <countStudents ; i++) {
            int attendances = Integer.parseInt(scanner.nextLine());
            totalBonus = attendances*1.0/countLectures*(5+initialBonus);
                    if(totalBonus>maxBonus){
                        maxBonus=totalBonus;
                        maxLectures=attendances;
                    }
        }
        System.out.printf("Max Bonus: %.0f.%nThe student has attended %d lectures.", maxBonus,maxLectures);

    }
}
