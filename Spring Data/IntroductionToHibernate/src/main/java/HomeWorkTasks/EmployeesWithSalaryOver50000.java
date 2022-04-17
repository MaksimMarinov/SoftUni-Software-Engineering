package HomeWorkTasks;

import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class EmployeesWithSalaryOver50000 extends HomeWorkImpl{
    public EmployeesWithSalaryOver50000(EntityManager em) {
        super(em);
    }

    @Override
    public void solveTask() {

       em.createQuery("SELECT e FROM Employee e where e.salary>:min_salary", Employee.class)
               .setParameter("min_salary", new BigDecimal(50000))
       .getResultStream().map(Employee::getFirstName).forEach(System.out::println);


    }
}
