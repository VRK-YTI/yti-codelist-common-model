package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Proxy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Object model that represents a postal code entity.
 */
@Entity
@JsonFilter("postalCode")
@Table(name ="postalcode")
@Proxy(lazy = false)
@XmlRootElement
@XmlType(propOrder = { "codeValue", "uri", "id", "source", "status", "modified", "prefLabels", "abbreviations", "typeCode", "typeName", "postManagementDistrict", "municipality"})
@JsonIgnoreProperties(value = { "validDate", "runDate" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "PostalCode", description = "PostalCode model that represents data for one single postal code.")
public class PostalCode extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer typeCode;
    private String typeName;
    private String nameAbbrFinnish;
    private String nameAbbrSwedish;
    private String nameAbbrEnglish;
    private Date runDate;
    private Date validDate;
    private Municipality municipality;
    private PostManagementDistrict postManagementDistrict;
    private Map<String, String> abbreviations;

    public PostalCode() {
        abbreviations = new HashMap<>();
    }

    @XmlTransient
    @Transient
    public Date getRunDate() {
        if (runDate != null) {
            return new Date(runDate.getTime());
        }
        return null;
    }

    public void setRunDate(final Date runDate) {
        if (runDate != null) {
            this.runDate = new Date(runDate.getTime());
        }
        this.runDate = null;
    }

    @XmlTransient
    @Transient
    public Date getValidDate() {
        if (validDate != null) {
            return new Date(validDate.getTime());
        }
        return null;
    }

    public void setValidDate(final Date validDate) {
        if (validDate != null) {
            this.validDate = new Date(validDate.getTime());
        }
        this.validDate = null;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "municipality_id")
    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(final Municipality municipality) {
        this.municipality = municipality;
    }

    @Column(name = "typecode")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(final Integer typeCode) {
        this.typeCode = typeCode;
    }

    @Column(name = "typename")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(final String typeName) {
        this.typeName = typeName;
    }

    @JsonIgnore
    @Column(name = "nameabbr_fi")
    public String getNameAbbrFinnish() {
        return nameAbbrFinnish;
    }

    public void setNameAbbrFinnish(final String nameAbbrFinnish) {

        addAbbreviation("fi", nameAbbrFinnish);
        this.nameAbbrFinnish = nameAbbrFinnish;

    }

    @JsonIgnore
    @Column(name = "nameabbr_se")
    public String getNameAbbrSwedish() {
        return nameAbbrSwedish;
    }

    public void setNameAbbrSwedish(final String nameAbbrSwedish) {

        addAbbreviation("se", nameAbbrSwedish);
        this.nameAbbrSwedish = nameAbbrSwedish;

    }

    @JsonIgnore
    @Column(name = "nameabbr_en")
    public String getNameAbbrEnglish() {
        return nameAbbrEnglish;
    }

    public void setNameAbbrEnglish(final String nameAbbrEnglish) {
        addAbbreviation("en", nameAbbrEnglish);
        this.nameAbbrEnglish = nameAbbrEnglish;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postmanagementdistrict_id", nullable = true, insertable = false, updatable = false)
    public PostManagementDistrict getPostManagementDistrict() {
        return postManagementDistrict;
    }

    public void setPostManagementDistrict(final PostManagementDistrict postManagementDistrict) {
        this.postManagementDistrict = postManagementDistrict;
    }

    @JsonProperty
    @Transient
    public Map<String, String> getAbbreviations() {

        return abbreviations;

    }

    private void addAbbreviation(final String language, final String abbreviation) {
        if (language != null && abbreviation != null && !abbreviation.isEmpty()) {
            abbreviations.put(language, abbreviation);

        } else if (language != null && abbreviation == null) {
            abbreviations.remove(language);
        }
    }

    @Override
    public String toString() {
        return "(" +
                "codeValue: " + getCodeValue() + ", " +
                "uri: " + getUri() + ", " +
                "source: " + getSource() + ", " +
                "status: " + getStatus() + ", " +
                "modified: " + getModified() + ", " +
                "runDate: " + runDate + ", " +
                "validDate: " + validDate + ", " +
                "typeCode: " + typeCode + ", " +
                "typeName: '" + typeName + ", " +
                "prefLabels: '" + getPrefLabels() + ", " +
                "abbreviations: '" + getAbbreviations() + ")";
    }

}
