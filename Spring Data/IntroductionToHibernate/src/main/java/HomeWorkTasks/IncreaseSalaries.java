package HomeWorkTasks;

import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class IncreaseSalaries extends HomeWorkImpl{
    public IncreaseSalaries(EntityManager em) {
        super(em);
    }

    @Override
    public void solveTask() {

        List<String> departmentsToIncrease = Arrays.asList(
                "Engineering",
                "Tool Design",
                "Marketing",
                "Information Services");
        em.getTransaction().begin();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e WHERE e.department.name IN(:deps)", Employee.class)
                .setParameter("deps", departmentsToIncrease)
                .getResultList();
        double increasingPercent = 0.12;
        employees.forEach(employee -> employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1+increasingPercent))));
        em.getTransaction().commit();
        employees.forEach(e->{
            System.out.printf("%s %s ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary() );
        });
    }
}
