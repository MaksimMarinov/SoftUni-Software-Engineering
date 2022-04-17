package Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course extends BaseEntity {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer credits;
    private Teacher teacher;
    private Set<Student> students;


    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name", unique = true)
    public String getName() {
        return name;
    }
    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    @Column(name = "start_date")
    public LocalDate getStartDate() {
        return startDate;
    }
    @Column(name = "end_date")
    public LocalDate getEndDate() {
        return endDate;
    }

    @Column(name = "credits")
    public Integer getCredits() {
        return credits;
    }


    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    public Teacher getTeacher() {
        return teacher;
    }

    @ManyToMany(targetEntity = Student.class)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public Set<Student> getStudents() {
        return students;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Course() {
    }
}
