package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Object model that represents a single code scheme.
 */
@Entity
@JsonFilter("codeScheme")
@Table(name = "codescheme")
@XmlRootElement
@XmlType(propOrder = { "id", "codeValue", "prefLabels", "startDate", "endDate", "created", "modified", "status", "type", "version", "uri", "description", "definition", "changeNote" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "CodeScheme", description = "CodeScheme model that represents data for one single codescheme.")
public class CodeScheme extends AbstractCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String m_version;

    private String m_type;

    private String m_changeNote;

    private String m_description;

    private String m_definition;

    private Map<String, String> m_prefLabels;

    private CodeRegistry m_codeRegistry;


    public CodeScheme() {

        m_prefLabels = new HashMap<>();

    }

    public CodeScheme(final String codeValue,
                      final String url,
                      final String version,
                      final String type,
                      final String status) {

        super.setCodeValue(codeValue);
        super.setUri(url);
        super.setStatus(status);
        m_version = version;
        m_type = type;
        m_prefLabels = new HashMap<>();

    }

    @Column(name = "version")
    public String getVersion() {
        return m_version;
    }

    public void setVersion(final String version) {
        m_version = version;
    }


    @Column(name = "type")
    public String getType() {
        return m_type;
    }

    public void setType(final String type) {
        m_type = type;
    }


    @Column(name = "definition")
    public String getDefinition() {
        return m_definition;
    }

    public void setDefinition(final String definition) {
        m_definition = definition;
    }


    @Column(name = "description")
    public String getDescription() {
        return m_description;
    }

    public void setDescription(final String description) {
        m_description = description;
    }


    @Column(name = "changenote")
    public String getChangeNote() {
        return m_changeNote;
    }

    public void setChangeNote(final String changeNote) {
        m_changeNote = changeNote;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coderegistry_id", nullable = false, insertable = false, updatable = true)
    public CodeRegistry getCodeRegistry() {
        return m_codeRegistry;
    }

    public void setCodeRegistry(final CodeRegistry codeRegistry) {
        m_codeRegistry = codeRegistry;
    }


    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "codescheme_preflabel", joinColumns = @JoinColumn(name = "codescheme_id", referencedColumnName = "id"))
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
