/**
 *
 * @author leandro
 */

package DAO;

import Entities.Event;
import java.util.List;

public interface IEventDAO {
    
    public void save(Event e);
    public void edit(Event e);
    public void remove(Event e);
    public Event recover(Long id);
    public List<Event> searchByEventName(String eventName);
}
