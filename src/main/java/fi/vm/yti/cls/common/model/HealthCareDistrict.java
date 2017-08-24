package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;


/**
 * Object model that represents a healthcare district entity.
 */
@Entity
@JsonFilter("healthCareDistrict")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code", scope = HealthCareDistrict.class)
@Table(name = "healthcaredistrict")
@Proxy(lazy = false)
@XmlRootElement
@XmlType(propOrder = { "code", "url", "id", "source", "status", "created", "modified", "names", "specialAreaOfResponsibility", "abbreviation", "municipalities"})
@JsonIgnoreProperties(value = { "municipalities" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "HealthCareDistrict", description = "HealthCareDistrict model that represents data for one single healthcaredistrict.")
public class HealthCareDistrict extends AbstractCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String m_specialAreaOfResponsibility;

    private String m_abbreviation;

    private List<Municipality> m_municipalities;


    public HealthCareDistrict() {
    }


    @Column(name = "specialareaofresponsibility")
    public String getSpecialAreaOfResponsibility() {
        return m_specialAreaOfResponsibility;
    }

    public void setSpecialAreaOfResponsibility(final String specialAreaOfResponsibility) {
        m_specialAreaOfResponsibility = specialAreaOfResponsibility;
    }


    @Column(name = "abbreviation")
    public String getAbbreviation() {
        return m_abbreviation;
    }

    public void setAbbreviation(final String abbreviation) {
        m_abbreviation = abbreviation;
    }


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "healthcaredistrict_id", nullable = true)
    public List<Municipality> getMunicipalities() {
        return m_municipalities;
    }

    public void setMunicipalities(final List<Municipality> municipalities) {
        m_municipalities = municipalities;
    }


    @Override
    public String toString() {
        return "(" +
                "m_code: " + getCode() + ", " +
                "m_url: " + getUrl() + ", " +
                "m_source: " + getSource() + ", " +
                "m_status: " + getStatus() + ", " +
                "m_created: " + getCreated() + ", " +
                "m_modified: " + getModified() + ", " +
                "m_specialAreaOfResponsibility: " + getSpecialAreaOfResponsibility() + ", " +
                "m_names: " + getNames() + ", " +
                "m_abbreviation: " + getAbbreviation() + ")";
    }

}
