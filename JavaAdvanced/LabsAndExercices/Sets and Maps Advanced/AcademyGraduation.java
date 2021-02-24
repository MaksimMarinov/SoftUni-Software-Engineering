import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> studentsInfo = new TreeMap<>();
       while (numberOfStudents-->0){
           String name = scanner.nextLine();
           double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
           studentsInfo.put(name,grades);
       }
       studentsInfo.forEach((k,v)->{
           double average = 0;
           for (double value : v) {
               average += value;
           }
           average/=v.length;


           System.out.printf("%s is graduated with %s%n", k, average);
       });

    }
}
