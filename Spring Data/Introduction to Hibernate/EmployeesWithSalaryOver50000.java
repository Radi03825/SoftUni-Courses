import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeesWithSalaryOver50000 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.createQuery("SELECT e.firstName from Employee e WHERE e.salary > 50000", String.class)
                .getResultStream().forEach(System.out::println);

        em.getTransaction().commit();
    }
}
