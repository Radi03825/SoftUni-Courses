import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.PreparedStatement;

public class FindProjects {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.createQuery("SELECT p FROM Project p ORDER BY p.startDate DESC, p.name", Project.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(p -> System.out.println("Project name: " + p.getName() + "\nProject Description: " + p.getDescription() + "\nProject Start Date: " + p.getStartDate() + "\n"  + "Project End Date: " + p.getEndDate()));

        em.getTransaction().commit();
    }
}
