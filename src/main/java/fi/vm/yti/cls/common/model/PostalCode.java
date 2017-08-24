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
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code", scope = PostalCode.class)
@Table(name ="postalcode")
@Proxy(lazy = false)
@XmlRootElement
@XmlType(propOrder = { "code", "url", "id", "source", "status", "created", "modified", "names", "abbreviations", "typeCode", "typeName", "postManagementDistrict", "municipality"})
@JsonIgnoreProperties(value = { "validDate", "runDate" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "PostalCode", description = "PostalCode model that represents data for one single postal code.")
public class PostalCode extends AbstractCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer m_typeCode;

    private String m_typeName;

    private String m_nameAbbrFinnish;

    private String m_nameAbbrSwedish;

    private String m_nameAbbrEnglish;

    private Date m_runDate;

    private Date m_validDate;

    private Municipality m_municipality;

    private PostManagementDistrict m_postManagementDistrict;

    private Map<String, String> m_abbreviations;


    public PostalCode() {

        m_abbreviations = new HashMap<>();

    }


    @XmlTransient
    @Transient
    public Date getRunDate() {

        if (m_runDate != null) {
            return new Date(m_runDate.getTime());
        }
        return null;

    }

    public void setRunDate(final Date runDate) {

        if (runDate != null) {
            m_runDate = new Date(runDate.getTime());
        }
        m_runDate = null;

    }


    @XmlTransient
    @Transient
    public Date getValidDate() {

        if (m_validDate != null) {
            return new Date(m_validDate.getTime());
        }
        return null;

    }

    public void setValidDate(final Date validDate) {

        if (validDate != null) {
            m_validDate = new Date(validDate.getTime());
        }
        m_validDate = null;

    }


    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "municipality_id")
    public Municipality getMunicipality() {
        return m_municipality;
    }

    public void setMunicipality(final Municipality municipality) {
        m_municipality = municipality;
    }


    @Column(name = "typecode")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public Integer getTypeCode() {
        return m_typeCode;
    }

    public void setTypeCode(final Integer typeCode) {
        m_typeCode = typeCode;
    }


    @Column(name = "typename")
    public String getTypeName() {
        return m_typeName;
    }

    public void setTypeName(final String typeName) {
        m_typeName = typeName;
    }


    @JsonIgnore
    @Column(name = "nameabbr_fi")
    public String getNameAbbrFinnish() {
        return m_nameAbbrFinnish;
    }

    public void setNameAbbrFinnish(final String nameAbbrFinnish) {

        addAbbreviation("fi", nameAbbrFinnish);
        m_nameAbbrFinnish = nameAbbrFinnish;

    }


    @JsonIgnore
    @Column(name = "nameabbr_se")
    public String getNameAbbrSwedish() {
        return m_nameAbbrSwedish;
    }

    public void setNameAbbrSwedish(final String nameAbbrSwedish) {

        addAbbreviation("se", nameAbbrSwedish);
        m_nameAbbrSwedish = nameAbbrSwedish;

    }


    @JsonIgnore
    @Column(name = "nameabbr_en")
    public String getNameAbbrEnglish() {
        return m_nameAbbrEnglish;
    }

    public void setNameAbbrEnglish(final String nameAbbrEnglish) {

        addAbbreviation("en", nameAbbrEnglish);
        m_nameAbbrEnglish = nameAbbrEnglish;

    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postmanagementdistrict_id", nullable = true, insertable = false, updatable = false)
    public PostManagementDistrict getPostManagementDistrict() {
        return m_postManagementDistrict;
    }

    public void setPostManagementDistrict(final PostManagementDistrict postManagementDistrict) {
        m_postManagementDistrict = postManagementDistrict;
    }


    @JsonProperty
    @Transient
    public Map<String, String> getAbbreviations() {

        return m_abbreviations;

    }


    private void addAbbreviation(final String language, final String abbreviation) {

        if (language != null && abbreviation != null && !abbreviation.isEmpty()) {
            m_abbreviations.put(language, abbreviation);

        } else if (language != null && abbreviation == null) {
            m_abbreviations.remove(language);
        }

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
                "m_runDate: " + m_runDate + ", " +
                "m_validDate: " + m_validDate + ", " +
                "m_typeCode: " + m_typeCode + ", " +
                "m_typeName: '" + m_typeName + ", " +
                "m_names: '" + getNames() + ", " +
                "m_abbreviations: '" + getAbbreviations() + ")";
    }

}
