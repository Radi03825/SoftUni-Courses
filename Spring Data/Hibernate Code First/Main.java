import entries.Customer;
import entries.Product;
import entries.Sale;
import entries.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();



        em.getTransaction().commit();
    }
}
