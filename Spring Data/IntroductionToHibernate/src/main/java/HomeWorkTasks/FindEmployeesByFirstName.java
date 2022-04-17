package HomeWorkTasks;

import entities.Employee;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindEmployeesByFirstName extends HomeWorkImpl{
    public FindEmployeesByFirstName(EntityManager em) {
        super(em);
    }

    @Override
    public void solveTask() {
        System.out.println("Please enter the input: ");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = bf.readLine();
            this.em
                    .createQuery("SELECT e FROM Employee e "
                            + "WHERE e.firstName LIKE CONCAT(:start, '%')", Employee.class)
                    .setParameter("start", input)
                    .getResultStream().forEach(e->{
                System.out.printf("%s %s - %s - ($%.2f)%n", e.getFirstName(), e.getLastName(),
                        e.getJobTitle(), e.getSalary());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
