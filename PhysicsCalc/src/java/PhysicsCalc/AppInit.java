/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PhysicsCalc;

import java.util.List;
import java.util.Set;
import javax.naming.InitialContext;
import javax.persistence.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application listener.
 */
@WebListener()
public class AppInit implements ServletContextListener {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        // Get the persistence handler
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        // Begin a transaction, so all meals will be added at once.
        EntityTransaction trans = entityManager.getTransaction();
//        trans.begin();
        
        String equations[] = {"1001", "1002", "1003"};

               // Check if each equation is in database, and add if it isn't
        for (String eqTemp: equations) {
            TypedQuery query = entityManager.createQuery("SELECT e.id FROM Equation e where e.id = :param", Equation.class);
            query.setParameter("param", Integer.valueOf(eqTemp));
            List<Equation> results = query.getResultList();
            if (results.size() < 1) {
    //            Equation eq = new Equation();
      //          eq.setFuncstring(eqTemp);
    //            eq.setVars(varset);
  //              entityManager.persist(eq);
                sce.getServletContext().log("Missing equation with id = " + eqTemp);
            }
        }
        
            // Now commit all of our meals to the database
 //       trans.commit();
        entityManager.close();
   
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Do nothing
    }
}
