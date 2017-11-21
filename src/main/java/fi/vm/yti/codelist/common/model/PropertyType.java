package fi.vm.yti.codelist.common.model;

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
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

@Entity
@JsonFilter("propertyType")
@Table(name = "propertytype")
@XmlRootElement
@XmlType(propOrder = {"id", "uri", "context", "propertyUri", "localName", "type", "prefLabels", "definitions"})
@ApiModel(value = "PropertyType", description = "PropertyType model for data relation typing.")
public class PropertyType extends AbstractIdentifyableCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String uri;
    private String propertyUri;
    private String localName;
    private String context;
    private String type;
    private Map<String, String> prefLabels;
    private Map<String, String> definitions;

    @Column(name = "localname")
    @JsonView(Views.Normal.class)
    public String getLocalName() {
        return localName;
    }

    public void setLocalName(final String localName) {
        this.localName = localName;
    }

    @Column(name = "context")
    @JsonView(Views.Normal.class)
    public String getContext() {
        return context;
    }

    public void setContext(final String context) {
        this.context = context;
    }

    @Column(name = "type")
    @JsonView(Views.Normal.class)
    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @Column(name = "uri")
    @JsonView(Views.Normal.class)
    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    @Column(name = "propertyuri")
    @JsonView(Views.Normal.class)
    public String getPropertyUri() {
        return propertyUri;
    }

    public void setPropertyUri(final String propertyUri) {
        this.propertyUri = propertyUri;
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "propertytype_preflabel", joinColumns = @JoinColumn(name = "propertytype_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "preflabel")
    @OrderColumn
    @JsonView(Views.Normal.class)
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
            prefLabel = prefLabels.get(LANGUAGE_CODE_EN);
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
    @CollectionTable(name = "propertytype_definition", joinColumns = @JoinColumn(name = "propertytype_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "definition")
    @OrderColumn
    @JsonView(Views.Normal.class)
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

    public void setDefinition(final String language, final String name) {
        if (definitions == null) {
            definitions = new HashMap<>();
        }
        if (language != null && name != null && !name.isEmpty()) {
            definitions.put(language, name);
        } else if (language != null && name == null) {
            definitions.remove(language);
        }
        setDefinitions(definitions);
    }
}
