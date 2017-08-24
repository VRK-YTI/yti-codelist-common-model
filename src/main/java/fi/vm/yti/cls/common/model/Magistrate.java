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
@XmlType(propOrder = { "code", "url", "id", "source", "status", "created", "modified", "names" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "Magistrate", description = "Magistrate model that represents data for one single magistrate.")
public class Magistrate extends AbstractCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;


    public Magistrate() {
    }


    public String toString() {
        return "(" +
                "m_code: " + getCode() + ", " +
                "m_url: " + getUrl() + ", " +
                "m_source: " + getSource() + ", " +
                "m_status: " + getStatus() + ", " +
                "m_created: " + getCreated() + ", " +
                "m_modified: " + getModified() + ", " +
                "m_names: " + getNames() + ")";
    }

}
