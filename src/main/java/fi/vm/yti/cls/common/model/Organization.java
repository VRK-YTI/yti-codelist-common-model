package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "name", "email", "telephone" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "Organization", description = "Organization model that represents data for one single region.")
public class Organization {

    private String m_name;

    private String m_email;

    private String m_telephone;


    public Organization() {

    }


    public String getName() {
        return m_name;
    }

    public void setName(final String name) {
        m_name = name;
    }


    public String getEmail() {
        return m_email;
    }

    public void setEmail(final String email) {
        m_email = email;
    }


    public String getTelephone() {
        return m_telephone;
    }

    public void setTelephone(final String telephone) {
        m_telephone = telephone;
    }

}
