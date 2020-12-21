import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, List<String>> studentInfo = new LinkedHashMap<>();
        while(!command.equals("end")){
            String [] tokens = command.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];
            studentInfo.putIfAbsent(courseName, new ArrayList<>());
            studentInfo.get(courseName).add(studentName);

            command= scanner.nextLine();
        }
       studentInfo.entrySet().stream().sorted((l,r)->r.getValue().size()-l.getValue().size())
               .forEach(e->{
                   System.out.println(e.getKey()+" : "+e.getValue().size());
                   e.getValue().stream().sorted().forEach(s -> System.out.println("-- "+s));
               });

    }
}
