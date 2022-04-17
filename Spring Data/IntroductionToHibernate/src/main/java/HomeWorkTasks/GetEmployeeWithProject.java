package HomeWorkTasks;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class GetEmployeeWithProject extends HomeWorkImpl{
    public GetEmployeeWithProject(EntityManager em) {
        super(em);
    }

    @Override
    public void solveTask() {
        System.out.println("Please enter employee id:");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            Integer id = Integer.parseInt(bf.readLine());
            Employee employee= em.find(Employee.class, id );
            System.out.printf("%s %s - %s%n", employee.getFirstName(),
                    employee.getLastName(), employee.getJobTitle());
            employee.getProjects().stream().sorted(Comparator.comparing(Project::getName)).forEach(project -> System.out.println(project.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
