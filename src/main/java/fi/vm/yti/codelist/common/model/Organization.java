package fi.vm.yti.codelist.common.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

@XmlType(propOrder = {"id", "url", "prefLabels", "descriptions"})
@ApiModel(value = "Organization", description = "Organization model that represents data for one single organization.")
public class Organization extends AbstractIdentifyableCode {

    private String url;
    private Map<String, String> prefLabels;
    private Map<String, String> descriptions;

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
    @JsonView(Views.Normal.class)
    public Map<String, String> getPrefLabels() {
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

    public void setPrefLabel(final String language, final String prefLabel) {
        if (prefLabels == null) {
            prefLabels = new HashMap<>();
        }
        if (language != null && prefLabel != null && !prefLabel.isEmpty()) {
            prefLabels.put(language, prefLabel);
        } else if (language != null && prefLabel == null) {
            prefLabels.remove(language);
        }
        setPrefLabels(prefLabels);
    }

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "organization_description", joinColumns = @JoinColumn(name = "organization_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "language")
    @Column(name = "description")
    @OrderColumn
    @JsonView(Views.Normal.class)
    public Map<String, String> getDescriptions() {
        if (descriptions == null) {
            descriptions = new HashMap<>();
        }
        return descriptions;
    }

    public void setDescriptions(final Map<String, String> descriptions) {
        this.descriptions = descriptions;
    }

    public String getDescription(final String language) {
        String description = descriptions.get(language);
        if (description == null) {
            description = descriptions.get(LANGUAGE_CODE_EN);
        }
        return description;
    }

    public void setDescription(final String language, final String description) {
        if (descriptions == null) {
            descriptions = new HashMap<>();
        }
        if (language != null && description != null && !description.isEmpty()) {
            descriptions.put(language, description);
        } else if (language != null && description == null) {
            descriptions.remove(language);
        }
        setDescriptions(descriptions);
    }
}
