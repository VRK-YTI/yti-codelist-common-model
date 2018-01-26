package fi.vm.yti.codelist.common.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@JsonFilter("externalReference")
@Table(name = "externalreference")
@XmlRootElement
@XmlType(propOrder = {"id", "uri", "url", "global", "title", "description", "parentCodeScheme"})
@ApiModel(value = "ExternalReference", description = "ExternalReference model that represents data for either CodeScheme or Code related external link.")
public class ExternalReference extends AbstractBaseCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String url;
    private Map<String, String> title;
    private Map<String, String> description;
    private Set<CodeScheme> codeSchemes;
    private Set<Code> codes;
    private PropertyType propertyType;
    private CodeScheme parentCodeScheme;
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

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "externalreference_title", joinColumns = @JoinColumn(name = "externalreference_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "title")
    @OrderColumn
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
        String titleValue = this.title.get(language);
        if (titleValue == null) {
            titleValue = this.title.get(LANGUAGE_CODE_EN);
        }
        return titleValue;
    }

    public void setTitle(final String language, final String name) {
        if (title == null) {
            title = new HashMap<>();
        }
        if (language != null && name != null && !name.isEmpty()) {
            title.put(language, name);
        } else if (language != null && name == null) {
            title.remove(language);
        }
        setTitle(title);
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "externalreference_description", joinColumns = @JoinColumn(name = "externalreference_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "description")
    @OrderColumn
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

    public void setDescription(final String language, final String name) {
        if (description == null) {
            description = new HashMap<>();
        }
        if (language != null && name != null && !name.isEmpty()) {
            description.put(language, name);
        } else if (language != null && name == null) {
            description.remove(language);
        }
        setDescription(description);
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "externalReferences")
    @JsonView(Views.ExtendedExternalReference.class)
    public Set<CodeScheme> getCodeSchemes() {
        return this.codeSchemes;
    }

    public void setCodeSchemes(final Set<CodeScheme> codeSchemes) {
        this.codeSchemes = codeSchemes;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "externalReferences")
    @JsonView(Views.ExtendedExternalReference.class)
    public Set<Code> getCodes() {
        return this.codes;
    }

    public void setCodes(final Set<Code> codes) {
        this.codes = codes;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "propertytype_id", nullable = false, insertable = true, updatable = true)
    @JsonView(Views.Normal.class)
    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(final PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentcodescheme_id", nullable = false, insertable = true, updatable = false)
    @JsonView(Views.ExtendedExternalReference.class)
    public CodeScheme getParentCodeScheme() {
        return parentCodeScheme;
    }

    public void setParentCodeScheme(final CodeScheme codeScheme) {
        this.parentCodeScheme = codeScheme;
    }
}
