import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentExercise {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Students> studentsList=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            String[] line= scanner.nextLine().split("\\s+");
            double grade= Double.parseDouble(line[2]);
            Students students = new Students(line[0], line[1],grade);
            studentsList.add(students);
        }
        studentsList.stream().sorted((s1,s2)->Double.compare(s2.getGrade(), s1.getGrade()))
                .forEach(student->System.out.println(student.studentInfo()));

    }
    public static class Students{
        String firstName;
        String lastName;
        double grade;

        public Students(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;

        }
        public String studentInfo() {
            return String.format("%s %s: %.2f",getFirstName(), getLastName(), getGrade() );
        }
    }



}
