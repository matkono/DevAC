/**
 *
 * @author leandro
 */

package Entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "EDITION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edition.findAll", query = "SELECT e FROM Edition e")
    , @NamedQuery(name = "Edition.findById", query = "SELECT e FROM Edition e WHERE e.id = :id")
    , @NamedQuery(name = "Edition.findByNumber", query = "SELECT e FROM Edition e WHERE e.number = :number")
    , @NamedQuery(name = "Edition.findByMainYear", query = "SELECT e FROM Edition e WHERE e.mainYear = :mainYear")
    , @NamedQuery(name = "Edition.findByDateInit", query = "SELECT e FROM Edition e WHERE e.dateInit = :dateInit")
    , @NamedQuery(name = "Edition.findByDateFinal", query = "SELECT e FROM Edition e WHERE e.dateFinal = :dateFinal")
    , @NamedQuery(name = "Edition.findByMainCity", query = "SELECT e FROM Edition e WHERE e.mainCountry = :mainCountry")})
public class Edition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "NUMBER")
    private String number;
    @Size(max = 255)
    @Column(name = "MAINYEAR")
    private String mainYear;
    @Size(max = 255)
    @Column(name = "DATEINIT")
    private String dateInit;
    @Size(max = 255)
    @Column(name = "DATEFINAL")
    private String dateFinal;
    @Size(max = 255)
    @Column(name = "MAINCITY")
    private String mainCity;
    @Size(max = 255)
    @Column(name = "MAINCOUNTRY")
    private String mainCountry;
    @ManyToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
    private Event event;

    public Edition() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMainYear() {
        return mainYear;
    }

    public void setMainYear(String mainYear) {
        this.mainYear = mainYear;
    }

    public String getDateInit() {
        return dateInit;
    }

    public void setDateInit(String dateInit) {
        this.dateInit = dateInit;
    }

    public String getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(String dateFinal) {
        this.dateFinal = dateFinal;
    }

    public String getMainCity() {
        return mainCity;
    }

    public void setMainCity(String mainCity) {
        this.mainCity = mainCity;
    }

    public String getMainCountry() {
        return mainCountry;
    }

    public void setMainCountry(String mainCountry) {
        this.mainCountry = mainCountry;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}