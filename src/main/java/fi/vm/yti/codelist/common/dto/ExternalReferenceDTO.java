package fi.vm.yti.codelist.common.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

@JsonFilter("externalReference")
@XmlRootElement
@XmlType(propOrder = {"id", "uri", "url", "global", "title", "description", "parentCodeScheme"})
@ApiModel(value = "ExternalReference", description = "ExternalReference model that represents data for either CodeScheme or Code related external link.")
public class ExternalReferenceDTO extends AbstractBaseCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String url;
    private Map<String, String> title;
    private Map<String, String> description;
    private Set<CodeSchemeDTO> codeSchemes;
    private Set<CodeDTO> codes;
    private PropertyTypeDTO propertyType;
    private CodeSchemeDTO parentCodeScheme;
    private Boolean global;

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    @Column(name = "global")
    public Boolean getGlobal() {
        return global;
    }

    public void setGlobal(final Boolean global) {
        this.global = global;
    }

    @JsonView(Views.Normal.class)
    public Map<String, String> getTitle() {
        if (title == null) {
            title = new HashMap<>();
        }
        return title;
    }

    public void setTitle(final Map<String, String> title) {
        this.title = title;
    }

    public String getTitle(final String language) {
        String value = this.title.get(language);
        if (value == null) {
            value = this.title.get(LANGUAGE_CODE_EN);
        }
        return value;
    }

    public void setTitle(final String language, final String value) {
        if (title == null) {
            title = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            title.put(language, value);
        } else if (language != null) {
            title.remove(language);
        }
        setTitle(title);
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
        String value = this.description.get(language);
        if (value == null) {
            value = this.description.get(LANGUAGE_CODE_EN);
        }
        return value;
    }

    public void setDescription(final String language, final String value) {
        if (description == null) {
            description = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            description.put(language, value);
        } else if (language != null) {
            description.remove(language);
        }
        setDescription(description);
    }

    @JsonView(Views.ExtendedExternalReference.class)
    public Set<CodeSchemeDTO> getCodeSchemes() {
        return this.codeSchemes;
    }

    public void setCodeSchemes(final Set<CodeSchemeDTO> codeSchemes) {
        this.codeSchemes = codeSchemes;
    }

    @JsonView(Views.ExtendedExternalReference.class)
    public Set<CodeDTO> getCodes() {
        return this.codes;
    }

    public void setCodes(final Set<CodeDTO> codes) {
        this.codes = codes;
    }

    @JsonView(Views.Normal.class)
    public PropertyTypeDTO getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(final PropertyTypeDTO propertyType) {
        this.propertyType = propertyType;
    }

    @JsonView(Views.ExtendedExternalReference.class)
    public CodeSchemeDTO getParentCodeScheme() {
        return parentCodeScheme;
    }

    public void setParentCodeScheme(final CodeSchemeDTO codeScheme) {
        this.parentCodeScheme = codeScheme;
    }
}
