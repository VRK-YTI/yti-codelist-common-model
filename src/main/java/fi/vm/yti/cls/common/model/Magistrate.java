package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Object model that represents a magistrate entity.
 */
@Entity
@JsonFilter("magistrate")
@Table(name ="magistrate")
@XmlType(propOrder = { "codeValue", "uri", "id", "source", "status", "modified", "prefLabels" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "Magistrate", description = "Magistrate model that represents data for one single magistrate.")
public class Magistrate extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    public Magistrate() {}

    public String toString() {
        return "(" +
                "codeValue: " + getCodeValue() + ", " +
                "uri: " + getUri() + ", " +
                "source: " + getSource() + ", " +
                "status: " + getStatus() + ", " +
                "modified: " + getModified() + ", " +
                "prefLabels: " + getPrefLabels() + ")";
    }

}
