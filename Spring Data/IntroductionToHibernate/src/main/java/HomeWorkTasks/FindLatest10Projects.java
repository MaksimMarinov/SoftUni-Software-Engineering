package HomeWorkTasks;

import entities.Project;

import javax.persistence.EntityManager;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class FindLatest10Projects extends HomeWorkImpl{
    public FindLatest10Projects(EntityManager em) {
        super(em);
    }

    @Override
    public void solveTask() {
        em.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC, p.name", Project.class)
                .setMaxResults(10).getResultStream().sorted(Comparator.comparing(Project::getName)).forEach(p->{
            System.out.printf("Project name: %s\n" +
                    " \tProject Description: %s\n" +
                    " \tProject Start Date:%s\n" +
                    " \tProject End Date: %s\n", p.getName(), p.getDescription(),
                    p.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm:ss.s")),
                    p.getEndDate()==null?null:p.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm:ss.s")));
        });
    }
}
