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

@JsonFilter("codeRegistry")
@XmlRootElement
@XmlType(propOrder = { "id", "codeValue", "uri", "url", "prefLabel", "definition", "created", "modified", "codeSchemesUrl", "codeSchemes", "organizations" })
@ApiModel(value = "CodeRegistry", description = "CodeRegistry DTO that represents data for one single registry.")
public class CodeRegistryDTO extends AbstractCommonCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, String> prefLabel;
    private Map<String, String> definition;
    private Set<CodeSchemeDTO> codeSchemes;
    private String codeSchemesUrl;
    private Set<OrganizationDTO> organizations;

    @JsonView(Views.Normal.class)
    public String getCodeSchemesUrl() {
        return this.getUrl() + "/codeschemes/";
    }

    @JsonView(Views.ExtendedCodeRegistry.class)
    public Set<CodeSchemeDTO> getCodeSchemes() {
        return codeSchemes;
    }

    public void setCodeSchemes(final Set<CodeSchemeDTO> codeSchemes) {
        this.codeSchemes = codeSchemes;
    }

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

    public void setPrefLabel(final String language,
                             final String value) {
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

    public void setDefinition(final String language,
                              final String value) {
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

    @JsonView(Views.Normal.class)
    public Set<OrganizationDTO> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(final Set<OrganizationDTO> organizations) {
        this.organizations = organizations;
    }
}
