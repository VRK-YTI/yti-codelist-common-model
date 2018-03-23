package fi.vm.yti.codelist.common.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

@JsonFilter("codeScheme")
@XmlRootElement
@XmlType(propOrder = {"id", "codeValue", "uri", "url", "codesUrl", "codes", "prefLabel", "definition", "description", "changeNote", "startDate", "endDate", "modified", "status", "version", "source", "legalBase", "governancePolicy", "dataClassifications", "externalReferences"})
@ApiModel(value = "CodeScheme DTO", description = "CodeScheme model that represents data for one single codescheme.")
public class CodeSchemeDTO extends AbstractHistoricalCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String version;
    private String source;
    private String legalBase;
    private String governancePolicy;
    private Map<String, String> prefLabel;
    private Map<String, String> definition;
    private Map<String, String> description;
    private Map<String, String> changeNote;
    private Set<CodeDTO> codes;
    private String codesUrl;
    private CodeRegistryDTO codeRegistry;
    private Set<CodeDTO> dataClassifications;
    private Set<ExternalReferenceDTO> externalReferences;

    public CodeSchemeDTO() {
        prefLabel = new HashMap<>();
    }

    public CodeSchemeDTO(final String codeValue,
                         final String url,
                         final String version,
                         final String status) {
        super.setCodeValue(codeValue);
        super.setUri(url);
        super.setStatus(status);
        this.version = version;
        prefLabel = new HashMap<>();
    }

    @JsonView(Views.Normal.class)
    public String getCodesUrl() {
        return this.getUrl() + "codes/";
    }

    @JsonView(Views.Normal.class)
    public Set<CodeDTO> getCodes() {
        return codes;
    }

    public void setCodes(final Set<CodeDTO> codes) {
        this.codes = codes;
    }

    @JsonView(Views.Normal.class)
    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    @JsonView(Views.Normal.class)
    public String getSource() {
        return source;
    }

    public void setSource(final String source) {
        this.source = source;
    }

    @JsonView(Views.Normal.class)
    public String getLegalBase() {
        return legalBase;
    }

    public void setLegalBase(final String legalBase) {
        this.legalBase = legalBase;
    }

    @JsonView(Views.Normal.class)
    public String getGovernancePolicy() {
        return governancePolicy;
    }

    public void setGovernancePolicy(final String governancePolicy) {
        this.governancePolicy = governancePolicy;
    }

    @JsonView(Views.Normal.class)
    public CodeRegistryDTO getCodeRegistry() {
        return codeRegistry;
    }

    public void setCodeRegistry(final CodeRegistryDTO codeRegistry) {
        this.codeRegistry = codeRegistry;
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
    public Map<String, String> getChangeNote() {
        if (changeNote == null) {
            changeNote = new HashMap<>();
        }
        return changeNote;
    }

    public void setChangeNote(final Map<String, String> changeNote) {
        this.changeNote = changeNote;
    }

    public String getChangeNote(final String language) {
        String changeNoteValue = this.changeNote.get(language);
        if (changeNoteValue == null) {
            changeNoteValue = this.changeNote.get(LANGUAGE_CODE_EN);
        }
        return changeNoteValue;
    }

    public void setChangeNote(final String language, final String value) {
        if (this.changeNote == null) {
            this.changeNote = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            this.changeNote.put(language, value);
        } else if (language != null) {
            this.changeNote.remove(language);
        }
        setChangeNote(this.changeNote);
    }

    @JsonView(Views.ExtendedCodeScheme.class)
    public Set<ExternalReferenceDTO> getExternalReferences() {
        return this.externalReferences;
    }

    public void setExternalReferences(final Set<ExternalReferenceDTO> externalReferences) {
        this.externalReferences = externalReferences;
    }

    @JsonView(Views.ExtendedCodeScheme.class)
    public Set<CodeDTO> getDataClassifications() {
        return dataClassifications;
    }

    public void setDataClassifications(final Set<CodeDTO> dataClassifications) {
        this.dataClassifications = dataClassifications;
    }
}
