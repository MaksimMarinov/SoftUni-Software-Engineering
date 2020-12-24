import java.awt.print.PrinterGraphics;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> schedule = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toList());
       String command =scanner.nextLine();
       while(!command.equals("course start")){
           String[] arrayCommand = command.split("\\:+");
           if(isNotExists(schedule, arrayCommand[1])){
               switch (arrayCommand[0]){
                   case("Add"):

                schedule.add(arrayCommand[1]);
                       break;
                   case("Insert"):
                       int index = Integer.parseInt(arrayCommand[2]);
                       if (index >= 0 && index < schedule.size()) {
                           schedule.add(index, arrayCommand[1]);
                       }
                       break;

                   case("Exercise"):
                       schedule.add(arrayCommand[1]);
                       schedule.add(arrayCommand[1]+"-Exercise");
                       break;

           }


           }else{
               switch (arrayCommand[0]){
                   case("Remove"):
                       schedule.remove(arrayCommand[1]);
                       break;
                   case("Swap"):
                       String exOne = arrayCommand[1] + "-Exercise";
                       String exTwo = arrayCommand[2] + "-Exercise";
                       if(!isNotExists(schedule, arrayCommand[2])) {
                           int index1 = findIndex(schedule,arrayCommand[1]);
                           int index2 = findIndex(schedule,arrayCommand[2]);
                           Collections.swap(schedule, index1, index2);
                           if (schedule.contains(exOne)) {
                               schedule.remove(schedule.indexOf(exOne));
                               schedule.add(schedule.indexOf(arrayCommand[1]) + 1, exOne);
                           }
                           if (schedule.contains(exTwo)) {
                               schedule.remove(schedule.indexOf(exTwo));
                               schedule.add(schedule.indexOf(arrayCommand[2]) + 1, exTwo);
                           }
                       }
                       break;
                   case("Exercise"):
                       String ex1 = arrayCommand[1] + "-Exercise";

                       if (schedule.contains(arrayCommand[1]) && !schedule.contains(ex1)) {
                       int index = schedule.indexOf(arrayCommand[1]);
                       schedule.add(index + 1, ex1);
                   }

                       break;
               }
           }
           command =scanner.nextLine();

       }
        for (int i = 0; i <schedule.size() ; i++) {
            String output = schedule.get(i);
            System.out.println(i+1+"."+ output);

        }


    }
    private static boolean isNotExists(List<String> schedule, String command){
        boolean isNotExists = true;
        for (int i = 0; i < schedule.size(); i++) {
            if (command.equals(schedule.get(i))) {
                return false;
            }

        }return isNotExists;

    }
    private static int findIndex(List<String> schedule, String command){
        int index=0;
        for (int i = 0; i <schedule.size() ; i++) {
            if(schedule.get(i).equals(command)){
                index = i;
                break;
            }

        }return index;
    }

}
