package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * Object model that represents a single API endpoint.
 */
@Entity
@JsonFilter("register")
@Table(name = "register")
@XmlRootElement
@XmlType(propOrder = { "id", "names", "status", "type", "version", "url" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "Register", description = "Register model that represents data for one single register.")
public class Register extends AbstractCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String m_version;

    private String m_type;


    public Register() {

    }

    public Register(final String code,
                    final String url,
                    final String version,
                    final String type,
                    final String status) {

        super.setCode(code);
        super.setUrl(url);
        m_version = version;
        m_type = type;
        super.setStatus(status);

    }

    @Column(name = "version")
    public String getVersion() {
        return m_version;
    }

    public void setVersion(final String version) {
        m_version = version;
    }


    @Column(name = "type")
    public String getType() {
        return m_type;
    }

    public void setType(final String type) {
        m_type = type;
    }

}
