package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Proxy;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * Object model that represents a single code.
 */
@Entity
@JsonFilter("code")
@Table(name = "code")
@Proxy(lazy = false)
@XmlRootElement
@XmlType(propOrder = { "codeValue", "uri", "id", "source", "status", "startDate", "endDate","created", "modified", "prefLabels", "description", "definition", "codeScheme" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "Code", description = "Code model that represents data for one single generic registeritem.")
public class Code extends AbstractCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private CodeScheme m_codeSheme;

    private String m_description;

    private String m_definition;

    private Map<String, String> m_prefLabels;


    public Code() {

        m_prefLabels = new HashMap<>();

    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codescheme_id", nullable = false, insertable = true, updatable = false)
    public CodeScheme getCodeScheme() {
        return m_codeSheme;
    }

    public void setCodeScheme(final CodeScheme codeScheme) {
        m_codeSheme = codeScheme;
    }


    @Column(name = "description")
    public String getDescription() {
        return m_description;
    }

    public void setDescription(final String description) {
        m_description = description;
    }


    @Column(name = "definition")
    public String getDefinition() {
        return m_definition;
    }

    public void setDefinition(final String definition) {
        m_definition = definition;
    }


    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "code_preflabel", joinColumns = @JoinColumn(name = "code_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "preflabel")
    @OrderColumn
    public Map<String, String> getPrefLabels() {

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
