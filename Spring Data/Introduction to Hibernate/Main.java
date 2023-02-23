import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        String name = scanner.nextLine();

        Long count = em.createQuery("SELECT count(e) FROM Employee e WHERE concat_ws(' ' , e.firstName, e.lastName) = :name", Long.class).setParameter("name", name).getSingleResult();

        if (count == 0){
            System.out.println("No");
        }else {
            System.out.println("Yes");
        }

        em.getTransaction().commit();
    }
}
