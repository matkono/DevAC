/**
 *
 * @author leandro
 */

package DAO;

import Entities.Edition;
import JPAUtil.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EditionDAO implements IEditionDAO {

    private EntityManager em;
    
    @Override
    public void save(Edition ed) {
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(ed);
        em.flush();
        et.commit();
    }

    @Override
    public void edit(Edition ed) {
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(ed);
        em.flush();
        et.commit();
        em.close();
    }

    @Override
    public void remove(Edition ed) {
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        if (!em.contains(ed)) {
            ed = em.merge(ed);
        }

        em.remove(ed);
        em.flush();
        et.commit();
        em.close();
    }
    
    @Override
    public Edition recover(Long id) {
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Edition ed = em.find(Edition.class, id);
        et.commit();
        
        return ed;
    }
}
