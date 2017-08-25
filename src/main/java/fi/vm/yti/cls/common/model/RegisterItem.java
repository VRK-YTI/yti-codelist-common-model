package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Entity
@JsonFilter("registerItem")
@Table(name = "registeritem")
@Proxy(lazy = false)
@XmlRootElement
@XmlType(propOrder = { "register", "code", "url", "id", "source", "status", "created", "modified", "names", "parentRegister" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "Registeritem", description = "RegisterItem model that represents data for one single generic registeritem.")
public class RegisterItem  extends AbstractCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String m_register;

    private Register m_parentRegister;


    public String getRegister() {
        return m_register;
    }

    public void setRegister(final String register) {
        m_register = register;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "register_id", nullable = true, insertable = false, updatable = false)
    public Register getParentRegister() {
        return m_parentRegister;
    }

    public void setParentRegister(final Register parentRegister) {
        m_parentRegister = parentRegister;
    }


}
