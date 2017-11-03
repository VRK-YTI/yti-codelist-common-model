package fi.vm.yti.codelist.common.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

/**
 * Object model that represents a single code scheme.
 */
@Entity
@JsonFilter("codeScheme")
@Table(name = "codescheme")
@XmlRootElement
@XmlType(propOrder = {"id", "codeValue", "prefLabels", "definitions", "descriptions", "changeNotes", "startDate", "endDate", "modified", "status", "version", "uri"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "CodeScheme", description = "CodeScheme model that represents data for one single codescheme.")
public class CodeScheme extends AbstractHistoricalCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String version;
    private Map<String, String> prefLabels;
    private Map<String, String> definitions;
    private Map<String, String> descriptions;
    private Map<String, String> changeNotes;
    private CodeRegistry codeRegistry;
    private Set<ExternalReference> externalReferences;

    public CodeScheme() {
        prefLabels = new HashMap<>();
    }

    public CodeScheme(final String codeValue,
                      final String url,
                      final String version,
                      final String status) {
        super.setCodeValue(codeValue);
        super.setUri(url);
        super.setStatus(status);
        this.version = version;
        prefLabels = new HashMap<>();
    }

    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coderegistry_id", nullable = false, insertable = true, updatable = false)
    public CodeRegistry getCodeRegistry() {
        return codeRegistry;
    }

    public void setCodeRegistry(final CodeRegistry codeRegistry) {
        this.codeRegistry = codeRegistry;
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "codescheme_preflabel", joinColumns = @JoinColumn(name = "codescheme_id", referencedColumnName = "id"))
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
            prefLabel = prefLabels.get(LANGUAGE_CODE_EN);
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
    @CollectionTable(name = "codescheme_definition", joinColumns = @JoinColumn(name = "codescheme_id", referencedColumnName = "id"))
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
            definition = definitions.get(LANGUAGE_CODE_EN);
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
        setDefinitions(definitions);
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "codescheme_description", joinColumns = @JoinColumn(name = "codescheme_id", referencedColumnName = "id"))
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
        this.descriptions = descriptions;
    }

    public String getDescription(final String language) {
        String description = descriptions.get(language);
        if (description == null) {
            description = descriptions.get(LANGUAGE_CODE_EN);
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
        setDescriptions(descriptions);
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "codescheme_changenote", joinColumns = @JoinColumn(name = "codescheme_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "changenote")
    @OrderColumn
    public Map<String, String> getChangeNotes() {
        if (changeNotes == null) {
            changeNotes = new HashMap<>();
        }
        return changeNotes;
    }

    public void setChangeNotes(final Map<String, String> changeNotes) {
        this.changeNotes = changeNotes;
    }

    public String getChangeNote(final String language) {
        String changeNote = changeNotes.get(language);
        if (changeNote == null) {
            changeNote = changeNotes.get(LANGUAGE_CODE_EN);
        }
        return changeNote;
    }

    public void setChangeNote(final String language, final String changeNote) {
        if (changeNotes == null) {
            changeNotes = new HashMap<>();
        }
        if (language != null && changeNote != null && !changeNote.isEmpty()) {
            changeNotes.put(language, changeNote);
        } else if (language != null && changeNote == null) {
            changeNotes.remove(language);
        }
        setChangeNotes(changeNotes);
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "codescheme_externalreference",
        joinColumns = {
            @JoinColumn(name = "codescheme_id", referencedColumnName = "id", nullable = false, updatable = false)},
        inverseJoinColumns = {
            @JoinColumn(name = "externalreference_id", referencedColumnName = "id", nullable = false, updatable = false)})
    public Set<ExternalReference> getExternalReferences() {
        return this.externalReferences;
    }

    public void setExternalReferences(Set<ExternalReference> externalReferences) {
        this.externalReferences = externalReferences;
    }
}
