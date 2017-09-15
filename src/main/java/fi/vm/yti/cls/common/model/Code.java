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
@XmlType(propOrder = { "codeValue", "uri", "id", "source", "status", "startDate", "endDate", "modified", "prefLabels", "descriptions", "definitions", "codeScheme", "shortName" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "Code", description = "Code model that represents data for one single generic registeritem.")
public class Code extends AbstractCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private CodeScheme codeSheme;
    private String shortName;
    private Map<String, String> prefLabels;
    private Map<String, String> descriptions;
    private Map<String, String> definitions;

    public Code() {
        prefLabels = new HashMap<>();
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codescheme_id", nullable = false, insertable = true, updatable = false)
    public CodeScheme getCodeScheme() {
        return codeSheme;
    }

    public void setCodeScheme(final CodeScheme codeScheme) {
        this.codeSheme = codeScheme;
    }

    @Column(name = "shortname")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "code_preflabel", joinColumns = @JoinColumn(name = "code_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "preflabel")
    @OrderColumn
    public Map<String, String> getPrefLabels() {
        return prefLabels;
    }

    public void setPrefLabels(final Map<String, String> prefLabels) {
        this.prefLabels = prefLabels;
    }

    public String getPrefLabel(final String language) {
        String prefLabel = prefLabels.get(language);
        if (prefLabel == null) {
            prefLabel = prefLabels.get("en");
        }
        return prefLabel;
    }

    public void setPrefLabel(final String language, final String prefLabel) {
        if (prefLabels == null) {
            prefLabels = new HashMap<>();
        }
        if (language != null && prefLabel != null && !prefLabel.isEmpty()) {
            prefLabels.put(language, prefLabel);
        } else if (language != null && prefLabel == null) {
            prefLabels.remove(language);
        }
        setPrefLabels(prefLabels);
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "code_definition", joinColumns = @JoinColumn(name = "code_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "definition")
    @OrderColumn
    public Map<String, String> getDefinitions() {
        if (definitions == null) {
            definitions = new HashMap<>();
        }
        return definitions;
    }

    public void setDefinitions(final Map<String, String> definitions) {
        this.definitions = definitions;
    }

    public String getDefinition(final String language) {
        String definition = definitions.get(language);
        if (definition == null) {
            definition = definitions.get("en");
        }
        return definition;
    }

    public void setDefinition(final String language, final String definition) {
        if (definitions == null) {
            definitions = new HashMap<>();
        }
        if (language != null && definition != null && !definition.isEmpty()) {
            definitions.put(language, definition);
        } else if (language != null && definition == null) {
            definitions.remove(language);
        }
        setPrefLabels(definitions);
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "code_description", joinColumns = @JoinColumn(name = "code_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "description")
    @OrderColumn
    public Map<String, String> getDescriptions() {
        if (descriptions == null) {
            descriptions = new HashMap<>();
        }
        return descriptions;
    }

    public void setDescriptions(final Map<String, String> descriptions) {
        this.definitions = descriptions;
    }

    public String getDescription(final String language) {
        String description = descriptions.get(language);
        if (description == null) {
            description = descriptions.get("en");
        }
        return description;
    }

    public void setDescription(final String language, final String description) {
        if (descriptions == null) {
            descriptions = new HashMap<>();
        }
        if (language != null && description != null && !description.isEmpty()) {
            descriptions.put(language, description);
        } else if (language != null && description == null) {
            descriptions.remove(language);
        }
        setPrefLabels(descriptions);
    }

}
