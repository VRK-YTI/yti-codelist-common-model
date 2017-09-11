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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codeValue", scope = HealthCareDistrict.class)
@Table(name = "healthcaredistrict")
@Proxy(lazy = false)
@XmlRootElement
@XmlType(propOrder = { "codeValue", "uri", "id", "source", "status", "modified", "prefLabels", "specialAreaOfResponsibility", "abbreviation", "municipalities"})
@JsonIgnoreProperties(value = { "municipalities" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "HealthCareDistrict", description = "HealthCareDistrict model that represents data for one single healthcaredistrict.")
public class HealthCareDistrict extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String specialAreaOfResponsibility;
    private String abbreviation;
    private List<Municipality> municipalities;

    public HealthCareDistrict() {}

    @Column(name = "specialareaofresponsibility")
    public String getSpecialAreaOfResponsibility() {
        return specialAreaOfResponsibility;
    }

    public void setSpecialAreaOfResponsibility(final String specialAreaOfResponsibility) {
        this.specialAreaOfResponsibility = specialAreaOfResponsibility;
    }

    @Column(name = "abbreviation")
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(final String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "healthcaredistrict_id", nullable = true)
    public List<Municipality> getMunicipalities() {
        return municipalities;
    }

    public void setMunicipalities(final List<Municipality> municipalities) {
        this.municipalities = municipalities;
    }

    @Override
    public String toString() {
        return "(" +
                "codeValue: " + getCodeValue() + ", " +
                "uri: " + getUri() + ", " +
                "source: " + getSource() + ", " +
                "status: " + getStatus() + ", " +
                "modified: " + getModified() + ", " +
                "specialAreaOfResponsibility: " + getSpecialAreaOfResponsibility() + ", " +
                "prefLabels: " + getPrefLabels() + ", " +
                "abbreviation: " + getAbbreviation() + ")";
    }

}
