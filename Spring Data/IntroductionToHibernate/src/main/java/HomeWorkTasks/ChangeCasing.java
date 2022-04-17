package HomeWorkTasks;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ChangeCasing extends HomeWorkImpl{
    public ChangeCasing(EntityManager em){
        super(em) ;
    }
    @Override
    public void solveTask() {
    this.em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Town t SET t.name = UPPER( t.name) WHERE length(t.name)<=5 ");
        query.executeUpdate();
        em.getTransaction().commit();
    }
}
