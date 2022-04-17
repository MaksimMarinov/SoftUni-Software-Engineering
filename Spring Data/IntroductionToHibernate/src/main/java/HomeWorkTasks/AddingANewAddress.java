package HomeWorkTasks;

import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddingANewAddress extends HomeWorkImpl{
    public AddingANewAddress(EntityManager em) {
        super(em);
    }

    @Override
    public void solveTask() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please, enter last name of the employee:");
        try {
            em.getTransaction().begin();
            String lastName = bf.readLine();
            Employee employee = em.createQuery("SELECT e FROM Employee e " +
                    "where e.lastName = :lName", Employee.class).
            setParameter("lName", lastName).getSingleResult();
            Town town =  em.createQuery("SELECT t FROM Town t where t.name='Sofia'", Town.class).getSingleResult();
            Address address = new Address();
            address.setText("Vitoshka 15");
            address.setTown(town);
            this.em.persist(address);
           employee.setAddress(address);
           em.flush();
           em.getTransaction().commit();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
