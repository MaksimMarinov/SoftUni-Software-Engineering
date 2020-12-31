import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> personList = new ArrayList<>();
        while (!input.equals("End")) {
        String[] data = input.split("\\s+");
        int age = Integer.parseInt(data[2]);
        Person person=new Person(data[0], data[1],age );
        personList.add(person);

            input= scanner.nextLine();
        }
        personList.stream().sorted(Comparator.comparingInt(Person::getAge))
                .forEach(person -> System.out.println(person.toString()));


    }
    private static class Person{
        String name;
        String ID;
        int age;

        public Person(String name, String ID, int age) {
            this.name = name;
            this.ID = ID;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getID() {
            return ID;
        }

        public int getAge() {
            return age;
        }
        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", getName(), getID(), getAge());
        }
    }


}
