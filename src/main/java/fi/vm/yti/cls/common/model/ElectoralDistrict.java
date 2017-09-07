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
 * Object model that represents an electoral district entity.
 */
@Entity
@JsonFilter("electoralDistrict")
@Table(name ="electoraldistrict")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codeValue", scope = ElectoralDistrict.class)
@Proxy(lazy = false)
@XmlRootElement
@XmlType(propOrder = { "codeValue", "uri", "id", "source", "status", "created", "modified", "prefLabels", "municipalities" })
@JsonIgnoreProperties(value = { "municipalities" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "ElectoralDistrict", description = "ElectoralDistrict model that represents data for one single electoraldistrict.")
public class ElectoralDistrict extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Municipality> m_municipalities;


    public ElectoralDistrict() {
    }


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "electoraldistrict_id", nullable = true)
    public List<Municipality> getMunicipalities() {
        return m_municipalities;
    }

    public void setMunicipalities(final List<Municipality> municipalities) {
        m_municipalities = municipalities;
    }


    public String toString() {
        return "(" +
                "m_codeValue: " + getCodeValue() + ", " +
                "m_url: " + getUri() + ", " +
                "m_source: " + getSource() + ", " +
                "m_status: " + getStatus() + ", " +
                "m_created: " + getCreated() + ", " +
                "m_modified: " + getModified() + ", " +
                "m_prefLabels: " + getPrefLabels() + ")";
    }

}
