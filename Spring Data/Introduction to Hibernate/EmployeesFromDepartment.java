import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesFromDepartment {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        String department = "Research and Development";

        em.createQuery("SELECT e FROM Employee e WHERE e.department.name = :department" +
                " ORDER BY e.salary ASC, e.id ASC", Employee.class).setParameter("department", department)
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s from Research and Development - $%.2f\n", e.getFirstName(), e.getLastName(), e.getSalary()));


        em.getTransaction().commit();
    }
}
