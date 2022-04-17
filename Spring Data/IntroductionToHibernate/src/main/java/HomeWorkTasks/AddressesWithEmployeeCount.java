package HomeWorkTasks;

import entities.Address;

import javax.persistence.EntityManager;
import java.util.List;

public class AddressesWithEmployeeCount extends HomeWorkImpl {
    public AddressesWithEmployeeCount(EntityManager em) {
        super(em);
    }

    @Override
    public void solveTask() {

        List<Address> addressList = em.createQuery("SELECT a FROM Address a "+
                "ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10).getResultList();
        addressList.stream().forEach(address -> {
            System.out.printf("%s, %s %d%n", address.getText(), address.getTown() == null?"unknown":address.getTown().getName(), address.getEmployees().size() );
        });

    }
}
