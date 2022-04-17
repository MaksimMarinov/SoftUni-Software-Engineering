package HomeWorkTasks;

import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class EmployeesMaximumSalaries extends HomeWorkImpl{
    public EmployeesMaximumSalaries(EntityManager em) {
        super(em);
    }

    @Override
    public void solveTask() {
        em.createQuery("SELECT e.department.name,  MAX(e.salary) FROM Employee e " +
                "GROUP BY e.department.name " +
            "HAVING MAX(e.salary) NOT BETWEEN :low AND :up ", Object[].class)
            .setParameter("low", BigDecimal.valueOf(30000))
            .setParameter("up", BigDecimal.valueOf(70000))
            .getResultList().forEach(r-> System.out.println(r[0]+" "+r[1]));
    }
}
