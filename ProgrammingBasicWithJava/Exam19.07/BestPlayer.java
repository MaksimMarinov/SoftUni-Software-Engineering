import javax.xml.namespace.QName;
import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String goalMaster = "";
        int goalScorer = 0;

        while (true) {
            String name = scanner.nextLine();

            if (name.equals("END")){
                break;
            }
            int goals = Integer.parseInt(scanner.nextLine());
            if (goals>goalScorer){
                goalScorer=goals;
                goalMaster=name;
            }
            if (goals>=10){
                break;
            }


        }
        System.out.printf("%s is the best player!%n", goalMaster);
        if (goalScorer>=3){
            System.out.printf("He has scored %d goals and made a hat-trick !!!", goalScorer );
        }else {
            System.out.printf("He has scored %d goals.", goalScorer);
        }

    }
}
