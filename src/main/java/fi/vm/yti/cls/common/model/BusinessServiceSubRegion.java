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
 * Object model that represents a business service subregion entity.
 */
@Entity
@JsonFilter("businessServiceSubRegion")
@Table(name = "businessservicesubregion")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codeValue", scope = BusinessServiceSubRegion.class)
@Proxy(lazy = false)
@XmlRootElement
@XmlType(propOrder = { "codeValue", "uri", "id", "source", "status", "created", "modified", "prefLabels", "municipalities" })
@JsonIgnoreProperties(value = { "municipalities" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "BusinessServiceSubRegion", description = "BusinessServiceSubRegion model that represents data for one single businessservice-subregion.")
public class BusinessServiceSubRegion extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Municipality> m_municipalities;


    public BusinessServiceSubRegion() {
    }


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "businessservicesubregion_id", nullable = true)
    public List<Municipality> getMunicipalities() {
        return m_municipalities;
    }

    public void setMunicipalities(final List<Municipality> municipalities) {
        m_municipalities = municipalities;
    }


    public String toString() {
        return "(" +
                "m_codeValue: " + getCodeValue() + ", " +
                "m_uri: " + getUri() + ", " +
                "m_source: " + getSource() + ", " +
                "m_status: " + getStatus() + ", " +
                "m_created: " + getCreated() + ", " +
                "m_modified: " + getModified() + ", " +
                "m_prefLabels: " + getPrefLabels() + ")";
    }

}
