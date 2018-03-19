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
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

/**
 * Object model that represents a single code registry.
 */
@Entity
@JsonFilter("codeRegistry")
@Table(name = "coderegistry")
@XmlRootElement
@XmlType(propOrder = {"id", "codeValue", "uri", "url", "prefLabel", "definition", "modified", "codeSchemes", "organizations"})
@ApiModel(value = "CodeRegistry", description = "CodeRegistry model that represents data for one single registry.")
public class CodeRegistry extends AbstractCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, String> prefLabel;
    private Map<String, String> definition;
    private Map<String, String> codeSchemes;
    private Set<Organization> organizations;

    @Transient
    @JsonView(Views.Normal.class)
    public Map<String, String> getCodeSchemes() {
        codeSchemes = new HashMap<>();
        codeSchemes.put("uri", this.getUri() + "codeschemes/");
        return codeSchemes;
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "coderegistry_preflabel", joinColumns = @JoinColumn(name = "coderegistry_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language", nullable = true)
    @Column(name = "preflabel")
    @OrderColumn
    @JsonView(Views.Normal.class)
    public Map<String, String> getPrefLabel() {
        if (prefLabel == null) {
            prefLabel = new HashMap<>();
        }
        return prefLabel;
    }

    public void setPrefLabel(final Map<String, String> prefLabel) {
        this.prefLabel = prefLabel;
    }

    public String getPrefLabel(final String language) {
        String prefLabelValue = this.prefLabel.get(language);
        if (prefLabelValue == null) {
            prefLabelValue = this.prefLabel.get(LANGUAGE_CODE_EN);
        }
        return prefLabelValue;
    }

    public void setPrefLabel(final String language, final String value) {
        if (prefLabel == null) {
            prefLabel = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            prefLabel.put(language, value);
        } else if (language != null) {
            prefLabel.remove(language);
        }
        setPrefLabel(prefLabel);
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "coderegistry_definition", joinColumns = @JoinColumn(name = "coderegistry_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language", nullable = true)
    @Column(name = "definition")
    @OrderColumn
    @JsonView(Views.Normal.class)
    public Map<String, String> getDefinition() {
        if (definition == null) {
            definition = new HashMap<>();
        }
        return definition;
    }

    public void setDefinition(final Map<String, String> definition) {
        this.definition = definition;
    }

    public String getDefinition(final String language) {
        String definitionValue = this.definition.get(language);
        if (definitionValue == null) {
            definitionValue = this.definition.get(LANGUAGE_CODE_EN);
        }
        return definitionValue;
    }

    public void setDefinition(final String language, final String value) {
        if (definition == null) {
            definition = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            definition.put(language, value);
        } else if (language != null) {
            definition.remove(language);
        }
        setDefinition(definition);
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "coderegistry_organization",
        joinColumns = {
            @JoinColumn(name = "coderegistry_id", referencedColumnName = "id", nullable = false, updatable = false)},
        inverseJoinColumns = {
            @JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false, updatable = false)})
    @JsonView(Views.Normal.class)
    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(final Set<Organization> organizations) {
        this.organizations = organizations;
    }
}
