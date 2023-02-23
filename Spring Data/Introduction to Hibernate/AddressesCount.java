import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddressesCount {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC", Address.class).setMaxResults(10)
                .getResultStream()
                .forEach(a -> System.out.println(a.getText() + ", " + a.getTown().getName() + " - " + a.getEmployees().size() + " employees"));

        em.getTransaction().commit();
    }
}
