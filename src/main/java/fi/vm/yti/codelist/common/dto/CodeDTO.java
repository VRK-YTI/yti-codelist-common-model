package fi.vm.yti.codelist.common.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

import fi.vm.yti.codelist.common.model.Views;
import io.swagger.annotations.ApiModel;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

@JsonFilter("code")
@XmlRootElement
@XmlType(propOrder = {"id", "codeValue", "uri", "url", "status", "hierarchyLevel", "startDate", "endDate", "modified", "prefLabel", "description", "definition", "codeScheme", "shortName", "externalReferences", "broaderCodeId"})
@ApiModel(value = "Code", description = "Code model that represents data for one single code.")
public class CodeDTO extends AbstractHistoricalCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private CodeSchemeDTO codeSheme;
    private String shortName;
    private Integer hierarchyLevel;
    private Map<String, String> prefLabel;
    private Map<String, String> description;
    private Map<String, String> definition;
    private Set<ExternalReferenceDTO> externalReferences;
    private UUID broaderCodeId;
    private Integer flatOrder;
    private Integer childOrder;

    @JsonView(Views.Normal.class)
    public UUID getBroaderCodeId() {
        return broaderCodeId;
    }

    public void setBroaderCodeId(final UUID broaderCodeId) {
        this.broaderCodeId = broaderCodeId;
    }

    @JsonView(Views.ExtendedCode.class)
    public CodeSchemeDTO getCodeScheme() {
        return codeSheme;
    }

    public void setCodeScheme(final CodeSchemeDTO codeScheme) {
        this.codeSheme = codeScheme;
    }

    @JsonView(Views.Normal.class)
    public Integer getHierarchyLevel() {
        return hierarchyLevel;
    }

    public void setHierarchyLevel(final Integer hierarchyLevel) {
        this.hierarchyLevel = hierarchyLevel;
    }

    @JsonView(Views.Normal.class)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }

    @JsonView(Views.Normal.class)
    public Map<String, String> getPrefLabel() {
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
        if (this.prefLabel == null) {
            this.prefLabel = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            this.prefLabel.put(language, value);
        } else if (language != null) {
            this.prefLabel.remove(language);
        }
        setPrefLabel(this.prefLabel);
    }

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
        if (this.definition == null) {
            this.definition = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            this.definition.put(language, value);
        } else if (language != null) {
            this.definition.remove(language);
        }
        setDefinition(this.definition);
    }

    @JsonView(Views.Normal.class)
    public Map<String, String> getDescription() {
        if (description == null) {
            description = new HashMap<>();
        }
        return description;
    }

    public void setDescription(final Map<String, String> description) {
        this.description = description;
    }

    public String getDescription(final String language) {
        String descriptionValue = this.description.get(language);
        if (descriptionValue == null) {
            descriptionValue = this.description.get(LANGUAGE_CODE_EN);
        }
        return descriptionValue;
    }

    public void setDescription(final String language, final String value) {
        if (this.description == null) {
            this.description = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            this.description.put(language, value);
        } else if (language != null) {
            this.description.remove(language);
        }
        setDescription(this.description);
    }

    @JsonView(Views.Normal.class)
    public Integer getFlatOrder() {
        return flatOrder;
    }

    public void setFlatOrder(final Integer flatOrder) {
        this.flatOrder = flatOrder;
    }

    public Integer getChildOrder() {
        return childOrder;
    }

    public void setChildOrder(final Integer childOrder) {
        this.childOrder = childOrder;
    }

    @JsonView(Views.ExtendedCode.class)
    public Set<ExternalReferenceDTO> getExternalReferences() {
        return this.externalReferences;
    }

    public void setExternalReferences(final Set<ExternalReferenceDTO> externalReferences) {
        this.externalReferences = externalReferences;
    }
}
