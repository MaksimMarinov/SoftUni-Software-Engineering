import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentInfo = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());
            if (studentInfo.containsKey(name)) {
                studentInfo.get(name).add(grade);
            } else {
                studentInfo.put(name, new LinkedList<>());
                studentInfo.get(name).add(grade);
            }
        }

        studentInfo.entrySet().stream().filter(e->{
            double average = e.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            return average >= 4.50;
        }).sorted((l,r)->{
            double a1 = l.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            double a2 = r.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            return Double.compare(a2,a1);

        }).forEach(e-> {
            double average = e.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            System.out.printf("%s -> %.2f%n", e.getKey(), average );
        });
    }

}
