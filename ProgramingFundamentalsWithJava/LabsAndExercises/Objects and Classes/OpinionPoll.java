
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        
        List<Names> namesList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split(" ");
            
            int age = Integer.parseInt(info[1]);
            Names names = new Names(info[0], age);
            namesList.add(names);

        }
       namesList.stream().filter(person -> person.getAge()>30)
               .sorted((p1,p2)->p1.getName().compareTo(p2.getName()))
        .forEach(person-> System.out.println(person.toString()));

        }


    public static class Names{
        String name;
        int age;

        public Names(String s, int age) {
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", this.name, this.age );
        }
    }
}
