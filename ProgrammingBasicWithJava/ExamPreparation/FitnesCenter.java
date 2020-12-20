import java.util.Scanner;

public class FitnesCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int visitors = Integer.parseInt(scanner.nextLine());
        int peopleBack = 0;
        int peopleChest = 0;
        int peopleLegs = 0;
        int peopleAbs = 0;
        int peopleProteinShake = 0;
        int peopleProteinBar = 0;
        double protein = 0;
      double peopleWorkOut =0;
        for (int i = 1; i<=visitors; i++){
            String workoutKind = scanner.nextLine();
            if (workoutKind.equals("Back")){
                peopleBack++;
                peopleWorkOut++;
            }else if (workoutKind.equals("Chest")){
                peopleChest++;
                peopleWorkOut++;

            }else if (workoutKind.equals("Legs")){
                peopleLegs++;
                peopleWorkOut++;
            }else if (workoutKind.equals("Abs")){
                peopleAbs++;
                peopleWorkOut++;
            }else if (workoutKind.equals("Protein shake")){
                peopleProteinShake++;
                protein++;
            }else if(workoutKind.equals("Protein bar")){
                peopleProteinBar++;
                protein++;
            }
        }double percentWorkout = peopleWorkOut/visitors*100;
        double percentProtein = protein/visitors*100;
        System.out.printf(" %d - back%n", peopleBack);
        System.out.printf(" %d - chest%n", peopleChest);
        System.out.printf(" %d - legs%n", peopleLegs);
        System.out.printf(" %d - abs%n", peopleAbs);
        System.out.printf(" %d - protein shake%n", peopleProteinShake);
        System.out.printf(" %d - protein bar%n", peopleProteinBar);
        System.out.printf("%.2f%% - work out%n", percentWorkout);
        System.out.printf("%.2f%% - protein", percentProtein);
    }
}
