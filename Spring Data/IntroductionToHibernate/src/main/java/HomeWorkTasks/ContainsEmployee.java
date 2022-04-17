package HomeWorkTasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainsEmployee extends HomeWorkImpl{
    public ContainsEmployee(EntityManager em) {
        super(em);
    }

    @Override
    public void solveTask() {
        System.out.print("Please enter first and last name of the employee ");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] fullName = bf.readLine().split("\\s+");
            String firstName = fullName[0];
            String lastName = fullName[1];
            this.em.getTransaction().begin();
             Long result =this.em.createQuery("SELECT COUNT(e) FROM Employee e " +
                    "WHERE e.firstName  = :first_name AND e.lastName = :last_name", Long.class)
                    .setParameter("first_name", firstName)
                    .setParameter("last_name", lastName)
            .getSingleResult();
            this.em.getTransaction().commit();
            System.out.println(result == 0 ?"No" : "Yes");

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
