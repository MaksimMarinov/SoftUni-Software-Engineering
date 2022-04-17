package HomeWorkTasks;

import entities.Employee;

import javax.persistence.EntityManager;

public class EmployeesFromDepartment extends HomeWorkImpl{
    public EmployeesFromDepartment(EntityManager em) {
        super(em);
    }

    @Override
    public void solveTask() {

        em.createQuery("SELECT e FROM Employee e WHERE e.department.name = :dep "+
                "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("dep", "Research and Development")
                .getResultList().forEach(employee -> System.out.printf("%s %s from %s - $%.2f%n", employee.getFirstName(),
                        employee.getLastName(), employee.getDepartment().getName(), employee.getSalary()));
    }
}
