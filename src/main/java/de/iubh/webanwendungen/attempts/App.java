package de.iubh.webanwendungen.attempts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {

            App app = new App();
            List<Pojo1> r= app.readData();
            if(r.isEmpty()) {
                System.out.println("Populating...");
                app.insertData();
            }
            r = app.readData();
            for(Pojo1 p: r) {
                System.out.println("- " + p.getId() + " : " + p.getAttr());
            }
            System.err.println("Finished");
            System.exit(0);

        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(0);
        }
    }

    private App() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("simple-jps-app");
        entityManager = factory.createEntityManager();
    }

    EntityManager entityManager;

    private void insertData() throws Throwable {

        BufferedReader bIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please give me an word: ");
        String word = bIn.readLine();

        entityManager.getTransaction().begin();
        Pojo1 p1 = new Pojo1(), p2 = new Pojo1();
        p1.setAttr("this is one");
        p2.setAttr(word);
        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.getTransaction().commit();
    }

    private List<Pojo1> readData() {
        String jpql = "SELECT p from Pojo1 p";
        Query query = entityManager.createQuery(jpql);
        List<Pojo1> result = (List<Pojo1>) query.getResultList();
        return result;
    }

}
