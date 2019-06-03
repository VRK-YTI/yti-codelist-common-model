package fi.vm.yti.codelist.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

@JsonFilter("extension")
@XmlRootElement
@XmlType(propOrder = { "id", "uri", "url", "membersUrl", "members", "codeValue", "status", "startDate", "endDate", "created", "modified", "prefLabel", "parentCodeScheme", "codeSchemes" })
@ApiModel(value = "Extension", description = "Extension DTO that represents data for one extension element.")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExtensionDTO extends AbstractHistoricalIdentifyableCodeWithStatusDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, String> prefLabel;
    private PropertyTypeDTO propertyType;
    private CodeSchemeDTO parentCodeScheme;
    private Set<CodeSchemeDTO> codeSchemes;
    private Set<MemberDTO> members;
    private String membersUrl;
    private String codeValue;
    private Date created;
    private Date modified;
    private String url;
    private String uri;

    @JsonView(Views.Normal.class)
    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    @JsonView(Views.Normal.class)
    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    @JsonView(Views.Normal.class)
    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(final String codeValue) {
        this.codeValue = codeValue;
    }

    @JsonView(Views.Normal.class)
    public String getMembersUrl() {
        return this.getUrl() + "/members/";
    }

    @ApiModelProperty(dataType = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @JsonView(Views.Normal.class)
    public Date getCreated() {
        if (created != null) {
            return new Date(created.getTime());
        }
        return null;
    }

    public void setCreated(final Date created) {
        if (created != null) {
            this.created = new Date(created.getTime());
        } else {
            this.created = null;
        }
    }

    @ApiModelProperty(dataType = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @JsonView(Views.Normal.class)
    public Date getModified() {
        if (modified != null) {
            return new Date(modified.getTime());
        }
        return null;
    }

    public void setModified(final Date modified) {
        if (modified != null) {
            this.modified = new Date(modified.getTime());
        } else {
            this.modified = null;
        }
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

    public void setPrefLabel(final String language,
                             final String value) {
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

    @JsonView({ Views.ExtendedExtension.class, Views.ExtendedMember.class })
    public Set<CodeSchemeDTO> getCodeSchemes() {
        return codeSchemes;
    }

    public void setCodeSchemes(final Set<CodeSchemeDTO> codeSchemes) {
        this.codeSchemes = codeSchemes;
    }

    @JsonView(Views.Normal.class)
    public PropertyTypeDTO getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(final PropertyTypeDTO propertyType) {
        this.propertyType = propertyType;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "extension", cascade = CascadeType.ALL)
    @JsonView({Views.ExtendedExtension.class, Views.ExtendedCode.class})
    public Set<MemberDTO> getMembers() {
        return members;
    }

    public void setMembers(final Set<MemberDTO> members) {
        this.members = members;
    }

    @JsonView({ Views.ExtendedExtension.class, Views.ExtendedMember.class })
    public CodeSchemeDTO getParentCodeScheme() {
        return parentCodeScheme;
    }

    public void setParentCodeScheme(final CodeSchemeDTO parentCodeScheme) {
        this.parentCodeScheme = parentCodeScheme;
    }
}
