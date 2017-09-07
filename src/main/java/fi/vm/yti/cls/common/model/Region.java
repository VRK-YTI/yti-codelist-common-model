package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Object model that represents a region entity.
 */
@Entity
@JsonFilter("region")
@Table(name = "region")
@XmlType(propOrder = { "codeValue", "uri", "id", "source", "status", "created", "modified", "prefLabels" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "Region", description = "Region model that represents data for one single region.")
public class Region extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    public Region() {}

    public String toString() {
        return "(" +
                "codeValue: " + getCodeValue() + ", " +
                "uri: " + getUri() + ", " +
                "source: " + getSource() + ", " +
                "created: " + getCreated() + ", " +
                "modified: " + getModified() + ", " +
                "prefLabels: " + getPrefLabels() + ")";
    }

}
