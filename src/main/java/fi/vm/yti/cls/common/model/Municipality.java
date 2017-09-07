package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Proxy;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Set;


/**
 * Object model that represents a municipality entity.
 */
@Entity
@JsonFilter("municipality")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codeValue", scope = Municipality.class)
@Table(name = "municipality")
@Proxy(lazy = false)
@XmlRootElement
@XmlType(propOrder = { "codeValue", "uri", "id", "source", "created", "modified", "prefLabels", "type", "languages", "magistrate", "region", "healthCareDistrict", "electoralDistrict", "magistrateServiceUnit", "businessServiceSubRegion" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "Municipality", description = "Municipality model that represents data for one single municipality.")
public class Municipality extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String m_type;

    private Set<String> m_languages;

    private Magistrate m_magistrate;

    private HealthCareDistrict m_healthCareDistrict;

    private Region m_region;

    private MagistrateServiceUnit m_magistrateServiceUnit;

    private ElectoralDistrict m_electoralDistrict;

    private BusinessServiceSubRegion m_businessServiceSubRegion;


    public Municipality() {
    }


    @Column(name = "type")
    public String getType() {
        return m_type;
    }

    public void setType(final String type) {
        m_type = type;
    }


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "municipality_language", joinColumns = @JoinColumn(name = "municipality_id"))
    @Column(name = "language")
    @OrderColumn
    public Set<String> getLanguages() {
        return m_languages;
    }

    public void setLanguages(final Set<String> languages) {
        m_languages = languages;
    }


    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "magistrate_id")
    public Magistrate getMagistrate() {
        return m_magistrate;
    }

    public void setMagistrate(final Magistrate magistrate) {
        m_magistrate = magistrate;
    }


    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "region_id")
    public Region getRegion() {
        return m_region;
    }

    public void setRegion(final Region region) {
        m_region = region;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "electoraldistrict_id", nullable = true, insertable = false, updatable = false)
    public ElectoralDistrict getElectoralDistrict() {
        return m_electoralDistrict;
    }

    public void setElectoralDistrict(final ElectoralDistrict electoralDistrict) {
        m_electoralDistrict = electoralDistrict;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "magistrateserviceunit_id", nullable = true, insertable = false, updatable = false)
    public MagistrateServiceUnit getMagistrateServiceUnit() {
        return m_magistrateServiceUnit;
    }

    public void setMagistrateServiceUnit(final MagistrateServiceUnit magistrateServiceUnit) {
        m_magistrateServiceUnit = magistrateServiceUnit;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "healthcaredistrict_id", nullable = true, insertable = false, updatable = false)
    public HealthCareDistrict getHealthCareDistrict() {
        return m_healthCareDistrict;
    }

    public void setHealthCareDistrict(final HealthCareDistrict healthCareDistrict) {
        m_healthCareDistrict = healthCareDistrict;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "businessservicesubregion_id", nullable = true, insertable = false, updatable = false)
    public BusinessServiceSubRegion getBusinessServiceSubRegion() {
        return m_businessServiceSubRegion;
    }

    public void setBusinessServiceSubRegion(final BusinessServiceSubRegion businessServiceSubRegion) {
        m_businessServiceSubRegion = businessServiceSubRegion;
    }


    @Override
    public String toString() {
        return "(" +
                "m_uri: " + getUri() + ", " +
                "m_codeValue: " + getCodeValue() + ", " +
                "m_source: " + getSource() + ", " +
                "m_status: " + getStatus() + ", " +
                "m_created: " + getCreated() + ", " +
                "m_modified: " + getModified() + ", " +
                "m_type: " + m_type + ", " +
                "m_languages: " + getLanguages() + ", " +
                "m_prefLabels: " + getPrefLabels() + ")";
    }

}
