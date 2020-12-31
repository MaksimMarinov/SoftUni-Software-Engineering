import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Student> studentList= new ArrayList<>();
        while (!line.equals("end")){
            String[] studentInfo = line.split("\\s+");
            int age = Integer.parseInt(studentInfo[2]);
            Student student = new Student(studentInfo[0], studentInfo[1], age,studentInfo[3]);
            studentList.add(student);

            line= scanner.nextLine();
        }
        String city = scanner.nextLine();
        for (Student student : studentList) {
            if(student.getCity().equals(city)){
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }

    }
    public static class Student{
        private String firstName;
        private String lastName;
        private int age;
        private String city;

        public Student(String firstName, String lastName, int age, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        public String getCity() {
            return city;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }
    }


}
