import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class GetEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        int id = Integer.parseInt(scanner.nextLine());

        em.createQuery("SELECT e FROM Employee e WHERE id = :id", Employee.class).setParameter("id", id)
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s - %s\n",e.getFirstName(), e.getLastName(), e.getJobTitle()));

        em.getTransaction().commit();
    }
}
