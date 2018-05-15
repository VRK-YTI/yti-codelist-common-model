package fi.vm.yti.codelist.common.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonFilter("extension")
@XmlRootElement
@XmlType(propOrder = { "id", "url", "code", "modified", "extensionValue", "order", "extensionScheme", "extension" })
@ApiModel(value = "Extension", description = "Extension DTO that represents data for one extension element.")
public class ExtensionDTO extends AbstractIdentifyableCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String extensionValue;
    private Integer order;
    private CodeDTO code;
    private ExtensionSchemeDTO extensionScheme;
    private ExtensionDTO extension;
    private Date modified;
    private String url;

    @JsonView(Views.Normal.class)
    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
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

    @JsonView(Views.Normal.class)
    public String getExtensionValue() {
        return extensionValue;
    }

    public void setExtensionValue(final String extensionValue) {
        this.extensionValue = extensionValue;
    }

    @JsonView(Views.Normal.class)
    public Integer getOrder() {
        return order;
    }

    public void setOrder(final Integer order) {
        this.order = order;
    }

    @JsonView(Views.ExtendedExtension.class)
    public CodeDTO getCode() {
        return code;
    }

    public void setCode(final CodeDTO code) {
        this.code = code;
    }

    @JsonView(Views.ExtendedExtension.class)
    public ExtensionSchemeDTO getExtensionScheme() {
        return extensionScheme;
    }

    public void setExtensionScheme(final ExtensionSchemeDTO extensionScheme) {
        this.extensionScheme = extensionScheme;
    }

    @JsonView(Views.ExtendedExtension.class)
    public ExtensionDTO getExtension() {
        return extension;
    }

    public void setExtension(final ExtensionDTO extension) {
        this.extension = extension;
    }
}