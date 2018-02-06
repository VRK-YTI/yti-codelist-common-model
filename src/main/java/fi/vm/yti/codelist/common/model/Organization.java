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
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

@Entity
@JsonFilter("organization")
@Table(name = "organization")
@XmlType(propOrder = {"id", "url", "prefLabel", "description", "codeRegistries"})
@ApiModel(value = "Organization", description = "Organization model that represents data for one single organization.")
public class Organization extends AbstractIdentifyableCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String url;
    private Map<String, String> prefLabel;
    private Map<String, String> description;
    private Set<CodeRegistry> codeRegistries;

    @Column(name = "url")
    @JsonView(Views.Normal.class)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "organization_preflabel", joinColumns = @JoinColumn(name = "organization_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "preflabel")
    @OrderColumn
    @JsonRawValue
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

    public void setPrefLabel(final String language, final String prefLabel) {
        if (this.prefLabel == null) {
            this.prefLabel = new HashMap<>();
        }
        if (language != null && prefLabel != null && !prefLabel.isEmpty()) {
            this.prefLabel.put(language, prefLabel);
        } else if (language != null && prefLabel == null) {
            this.prefLabel.remove(language);
        }
        setPrefLabel(this.prefLabel);
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "organization_description", joinColumns = @JoinColumn(name = "organization_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "description")
    @OrderColumn
    @JsonRawValue
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

    public void setDescription(final String language, final String description) {
        if (this.description == null) {
            this.description = new HashMap<>();
        }
        if (language != null && description != null && !description.isEmpty()) {
            this.description.put(language, description);
        } else if (language != null && description == null) {
            this.description.remove(language);
        }
        setDescription(this.description);
    }


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "organizations")
    @JsonView(Views.ExtendedOrganization.class)
    public Set<CodeRegistry> getCodeRegistries() {
        return codeRegistries;
    }

    public void setCodeRegistries(final Set<CodeRegistry> codeRegistries) {
        this.codeRegistries = codeRegistries;
    }
}
