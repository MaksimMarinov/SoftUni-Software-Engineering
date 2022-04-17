import Entities.WizardDeposits;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("test")
                .createEntityManager();

        entityManager.getTransaction().begin();
        WizardDeposits wizardDeposits = new WizardDeposits("Ivan", "Ivanov", 18);
        wizardDeposits.setDeposit_amount(BigDecimal.valueOf(18.8));
        entityManager.persist(wizardDeposits);
        entityManager.getTransaction().commit();
    }
}
