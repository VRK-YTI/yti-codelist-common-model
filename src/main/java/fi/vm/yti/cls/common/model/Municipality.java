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
@XmlType(propOrder = { "codeValue", "uri", "id", "source", "modified", "prefLabels", "type", "languages", "magistrate", "region", "healthCareDistrict", "electoralDistrict", "magistrateServiceUnit", "businessServiceSubRegion" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "Municipality", description = "Municipality model that represents data for one single municipality.")
public class Municipality extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String type;
    private Set<String> languages;
    private Magistrate magistrate;
    private HealthCareDistrict healthCareDistrict;
    private Region region;
    private MagistrateServiceUnit magistrateServiceUnit;
    private ElectoralDistrict electoralDistrict;
    private BusinessServiceSubRegion businessServiceSubRegion;

    public Municipality() {}

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "municipality_language", joinColumns = @JoinColumn(name = "municipality_id"))
    @Column(name = "language")
    @OrderColumn
    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(final Set<String> languages) {
        this.languages = languages;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "magistrate_id")
    public Magistrate getMagistrate() {
        return magistrate;
    }

    public void setMagistrate(final Magistrate magistrate) {
        this.magistrate = magistrate;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "region_id")
    public Region getRegion() {
        return region;
    }

    public void setRegion(final Region region) {
        this.region = region;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "electoraldistrict_id", nullable = true, insertable = false, updatable = false)
    public ElectoralDistrict getElectoralDistrict() {
        return electoralDistrict;
    }

    public void setElectoralDistrict(final ElectoralDistrict electoralDistrict) {
        this.electoralDistrict = electoralDistrict;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "magistrateserviceunit_id", nullable = true, insertable = false, updatable = false)
    public MagistrateServiceUnit getMagistrateServiceUnit() {
        return magistrateServiceUnit;
    }

    public void setMagistrateServiceUnit(final MagistrateServiceUnit magistrateServiceUnit) {
        this.magistrateServiceUnit = magistrateServiceUnit;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "healthcaredistrict_id", nullable = true, insertable = false, updatable = false)
    public HealthCareDistrict getHealthCareDistrict() {
        return healthCareDistrict;
    }

    public void setHealthCareDistrict(final HealthCareDistrict healthCareDistrict) {
        this.healthCareDistrict = healthCareDistrict;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "businessservicesubregion_id", nullable = true, insertable = false, updatable = false)
    public BusinessServiceSubRegion getBusinessServiceSubRegion() {
        return businessServiceSubRegion;
    }

    public void setBusinessServiceSubRegion(final BusinessServiceSubRegion businessServiceSubRegion) {
        this.businessServiceSubRegion = businessServiceSubRegion;
    }

    @Override
    public String toString() {
        return "(" +
                "uri: " + getUri() + ", " +
                "codeValue: " + getCodeValue() + ", " +
                "source: " + getSource() + ", " +
                "status: " + getStatus() + ", " +
                "modified: " + getModified() + ", " +
                "type: " + type + ", " +
                "languages: " + getLanguages() + ", " +
                "prefLabels: " + getPrefLabels() + ")";
    }

}
