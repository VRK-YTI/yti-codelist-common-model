package fi.vm.yti.codelist.common.dto;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;

@JsonFilter("searchHit")
@XmlRootElement
@XmlType(propOrder = { "type", "prefLabel", "uri" })
@ApiModel(value = "Code", description = "Code DTO that represents data for a single search hit.")
@JsonIgnoreProperties(value = { "expanded" })
public class SearchHitDTO {

    private String type;
    private Map<String, String> prefLabel;
    private String uri;

    @JsonView(Views.Normal.class)
    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @JsonView(Views.Normal.class)
    public Map<String, String> getPrefLabel() {
        return prefLabel;
    }

    public void setPrefLabel(final Map<String, String> prefLabel) {
        this.prefLabel = prefLabel;
    }

    @JsonView(Views.Normal.class)
    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }
}
