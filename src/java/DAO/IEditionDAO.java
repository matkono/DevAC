package DAO;

import Entities.Edition;

/**
 *
 * @author leandro
 */
public interface IEditionDAO {
    public void save(Edition e);
    public void edit(Edition e);
    public void remove(Edition e);
    public Edition recover(Long id);
}
