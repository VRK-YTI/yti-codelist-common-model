package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Proxy;

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
 * Object model that represents a magistrate service unit entity.
 */
@Entity
@JsonFilter("magistrateServiceUnit")
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "codeValue", scope = MagistrateServiceUnit.class)
@Table(name = "magistrateserviceunit")
@Proxy(lazy = false)
@XmlRootElement
@XmlType(propOrder = { "codeValue", "uri", "id", "source", "status", "created", "modified", "prefLabels", "municipalities"})
@JsonIgnoreProperties(value = { "municipalities" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "MagistrateServiceUnit", description = "MagistrateServiceUnit model that represents data for one single magistrate service unit.")
public class MagistrateServiceUnit extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Municipality> municipalities;

    public MagistrateServiceUnit() {}

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "magistrateserviceunit_id", nullable = true)
    public List<Municipality> getMunicipalities() {
        return municipalities;
    }

    public void setMunicipalities(final List<Municipality> municipalities) {
        this.municipalities = municipalities;
    }

    public String toString() {
        return "(" +
                "codeValue: " + getCodeValue() + ", " +
                "uri: " + getUri() + ", " +
                "source: " + getSource() + ", " +
                "status: " + getStatus() + ", " +
                "created: " + getCreated() + ", " +
                "modified: " + getModified() + ", " +
                "prefLabels: " + getPrefLabels() + ")";
    }

}
