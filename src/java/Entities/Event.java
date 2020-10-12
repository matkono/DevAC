/**
 *
 * @author leandro
 */

package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "EVENT")
/*@XmlRootElement*/
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
    , @NamedQuery(name = "Event.findById", query = "SELECT e FROM Event e WHERE e.id = :id")
    , @NamedQuery(name = "Event.findByName", query = "SELECT e FROM Event e WHERE e.name = :name")
    , @NamedQuery(name = "Event.findByInitials", query = "SELECT e FROM Event e WHERE e.initials = :initials")
    , @NamedQuery(name = "Event.findByConcentrationArea", query = "SELECT e FROM Event e WHERE e.concentrationArea = :concentrationArea")
    , @NamedQuery(name = "Event.findByInstitution", query = "SELECT e FROM Event e WHERE e.institution = :institution")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "INITIALS")
    private String initials;
    @Size(max = 255)
    @Column(name = "CONCENTRATIONAREA")
    private String concentrationArea;
    @Size(max = 255)
    @Column(name = "INSTITUTION")
    private String institution;
    @OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER, mappedBy = "event", orphanRemoval=true)
    @JoinColumn(name = "edition_id")
    private List<Edition> edition;

    public Event() {
    }

    public Event(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return this.initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getConcentrationArea() {
        return this.concentrationArea;
    }

    public void setConcentrationArea(String concentrationArea) {
        this.concentrationArea = concentrationArea;
    }

    public String getInstitution() {
        return this.institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public List<Edition> getEdition() {
        return this.edition;
    }

    public void setEdition(List<Edition> edition) {
        this.edition = edition;
    }
}
