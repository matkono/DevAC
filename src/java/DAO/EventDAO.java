/**
 *
 * @author leandro
 */

package DAO;

import Entities.Event;
import JPAUtil.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class EventDAO implements IEventDAO {
    private EntityManager em;
    
    @Override
    public void save(Event ev) {
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(ev);
        et.commit();
    }
    @Override
    public void edit(Event ev) {
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(ev);
        em.flush();
        et.commit();
        em.close();
    }

    @Override
    public void remove(Event ev) {
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        if (!em.contains(ev)) {
            ev = em.merge(ev);
        }

        em.remove(ev);
        em.flush();
        et.commit();
        em.close();
    }
    
    @Override
    public Event recover(Long id) {
        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Event ev = em.find(Event.class, id);
        et.commit();
        
        return ev;
    }
    
    @Override
    public List<Event> searchByEventName(String eventName) {
        em = JPAUtil.getEM();
        String jpqlQuery = "SELECT e FROM Event e WHERE e.name = :name";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("name", eventName);
        List<Event> e = query.getResultList();
        return e;
    }
}
