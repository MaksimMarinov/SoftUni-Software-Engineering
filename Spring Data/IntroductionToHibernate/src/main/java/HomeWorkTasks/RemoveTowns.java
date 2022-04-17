package HomeWorkTasks;

import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RemoveTowns extends HomeWorkImpl{
    public RemoveTowns(EntityManager em) {
        super(em);
    }

    @Override
    public void solveTask() {
        System.out.println("Please enter the name of the town:");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String townName = bf.readLine();

            Town town = em.createQuery("SELECT t FROM Town t WHERE t.name = :name", Town.class)
                    .setParameter("name", townName).getSingleResult();
           int affectedRows= removeAddressesByTownId(town.getId());
           em.remove(town);
           if(affectedRows==1){
               System.out.printf("%d address in %s deleted%n", affectedRows, townName);
           }else{
               System.out.printf("%d addresses in %s deleted%n", affectedRows, townName);
           }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int removeAddressesByTownId(Integer id) {
       em.getTransaction().begin();
      List<Address> addressList = em.createQuery("SELECT a FROM Address a " +
               "WHERE a.town.id = :id", Address.class)
               .setParameter("id", id)
               .getResultList();
      int result = addressList.size();
      addressList.forEach(a->a.getEmployees().forEach(e->e.setAddress(null)));
      addressList.forEach(em::remove);
       em.getTransaction().commit();
    return result ;
    }
}
