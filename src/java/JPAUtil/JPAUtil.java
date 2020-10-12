/**
 *
 * @author leandro
 */

package JPAUtil;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable {

   private static EntityManagerFactory emf;
   
   public static EntityManager getEM() {
       if (emf == null) {
           emf = Persistence.createEntityManagerFactory("TestePU");
       }
       return emf.createEntityManager();
   }
   
   public static void closeEMF() {
       emf.close();
   }
}