package classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Classroom {
    public int capacity;
    public List<Student> students;


    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();

    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }



    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < capacity) {
            if (this.students.contains(student)) {
                return "Student is already in the classroom";
            } else {
                students.add(student);
                return "Added student " + student.getFirstName() + " " + student.getLastName();
            }
        } else {
            return "No seats in the classroom";
        }
    }


    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {
            students.remove(student);
            return "Removed student " + student.getFirstName() + " " + student.getLastName();

        } else {
            return "Student not found";
        }
    }

    public String getSubjectInfo(String subject) {
        StringBuilder output = new StringBuilder();
        List<Student> filtered = this.students.stream().filter(student -> student.getBestSubject().equals(subject))
                .collect(Collectors.toList());
        if(filtered.isEmpty()){
            output.append("No students enrolled for the subject");
        }else{
            output.append("Subject: ").append(subject)
                    .append(System.lineSeparator()).append("Students:").append(System.lineSeparator());
            filtered.forEach(student->output.append(student.getFirstName())
            .append(" ").append(student.getLastName()).append(System.lineSeparator()));
        }
        return output.toString().trim();
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }

        }
        return students.get(0);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Classroom size: %d%n", students.size()));
        for (Student student : students) {
            sb.append(String.format("==Student: First Name= %s, Last Name= %s, Best Subject= %s%n", student.getFirstName(), student.getLastName(), student.getBestSubject()));

        }

        return sb.toString();
    }
}
