package fi.vm.yti.codelist.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

@JsonFilter("extensionscheme")
@XmlRootElement
@XmlType(propOrder = {"id", "url", "codeValue", "status", "startDate", "endDate", "modified", "prefLabel", "codeSchemes", "extensions"})
@ApiModel(value = "ExtensionScheme", description = "ExtensionScheme model that represents data for one extension scheme element.")
public class ExtensionSchemeDTO extends AbstractHistoricalIdentifyableCodeWithStatusDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, String> prefLabel;
    private PropertyTypeDTO propertyType;
    private Set<CodeSchemeDTO> codeSchemes;
    private Set<ExtensionDTO> extensions;
    private String codeValue;
    private Date modified;
    private String url;

    @JsonView(Views.Normal.class)
    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    @Column(name = "codevalue")
    @JsonView(Views.Normal.class)
    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(final String codeValue) {
        this.codeValue = codeValue;
    }

    @ApiModelProperty(dataType = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    @Temporal(TemporalType.TIMESTAMP)
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

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "extensionscheme_preflabel", joinColumns = @JoinColumn(name = "extensionscheme_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "preflabel")
    @OrderColumn
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

    @JsonView(Views.ExtendedExtensionScheme.class)
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "extensionScheme", cascade = CascadeType.ALL)
    @JsonView(Views.ExtendedExtensionScheme.class)
    public Set<ExtensionDTO> getExtensions() {
        return extensions;
    }

    public void setExtensions(final Set<ExtensionDTO> extensions) {
        this.extensions = extensions;
    }
}
