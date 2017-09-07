package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * Object model that represents a single code registry.
 */
@Entity
@JsonFilter("codeRegistry")
@Table(name = "coderegistry")
@XmlRootElement
@XmlType(propOrder = { "id", "codeValue", "prefLabels", "startDate", "endDate", "created", "modified", "status", "uri", "definition" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties("prefLabel")
@ApiModel(value = "CodeRegistry", description = "CodeRegistry model that represents data for one single registry.")
public class CodeRegistry extends AbstractCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String m_definition;

    private Map<String, String> m_prefLabels;

    @Column(name = "definition")
    public String getDefinition() {
        return m_definition;
    }

    public void setDefinition(final String definition) {
        m_definition = definition;
    }


    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "coderegistry_preflabel", joinColumns = @JoinColumn(name = "coderegistry_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "preflabel")
    @OrderColumn
    public Map<String, String> getPrefLabels() {

        if (m_prefLabels == null) {
            m_prefLabels = new HashMap<>();
        }

        return m_prefLabels;

    }

    public void setPrefLabels(final Map<String, String> prefLabels) {

        m_prefLabels = prefLabels;

    }

    public String getPrefLabel(final String language) {

        String prefLabel = m_prefLabels.get(language);

        if (prefLabel == null) {
            prefLabel = m_prefLabels.get("en");
        }

        return prefLabel;
    }

    public void setPrefLabel(final String language, final String name) {

        if (m_prefLabels == null) {
            m_prefLabels = new HashMap<>();
        }

        if (language != null && name != null && !name.isEmpty()) {
            m_prefLabels.put(language, name);

        } else if (language != null && name == null) {
            m_prefLabels.remove(language);
        }

        setPrefLabels(m_prefLabels);

    }

}
