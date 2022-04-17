package HomeWorkTasks;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

public abstract class HomeWorkImpl implements HomeWork{
protected EntityManager em;

    public HomeWorkImpl(EntityManager em) {
        this.em = em;
    }
}
