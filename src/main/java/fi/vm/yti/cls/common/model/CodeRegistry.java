package fi.vm.yti.cls.common.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;

/**
 * Object model that represents a single code registry.
 */
@Entity
@JsonFilter("codeRegistry")
@Table(name = "coderegistry")
@XmlRootElement
@XmlType(propOrder = { "id", "codeValue", "prefLabels", "definitions", "startDate", "endDate", "modified", "status", "uri" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "CodeRegistry", description = "CodeRegistry model that represents data for one single registry.")
public class CodeRegistry extends AbstractCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, String> prefLabels;
    private Map<String, String> definitions;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "coderegistry_preflabel", joinColumns = @JoinColumn(name = "coderegistry_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "preflabel")
    @OrderColumn
    public Map<String, String> getPrefLabels() {
        if (prefLabels == null) {
            prefLabels = new HashMap<>();
        }
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

    public void setPrefLabel(final String language, final String name) {
        if (prefLabels == null) {
            prefLabels = new HashMap<>();
        }
        if (language != null && name != null && !name.isEmpty()) {
            prefLabels.put(language, name);
        } else if (language != null && name == null) {
            prefLabels.remove(language);
        }
        setPrefLabels(prefLabels);
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "coderegistry_definition", joinColumns = @JoinColumn(name = "coderegistry_id", referencedColumnName = "id"))
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

    public void setDefinition(final String language, final String name) {
        if (definitions == null) {
            definitions = new HashMap<>();
        }
        if (language != null && name != null && !name.isEmpty()) {
            definitions.put(language, name);
        } else if (language != null && name == null) {
            definitions.remove(language);
        }
        setPrefLabels(definitions);
    }

}
