package fi.vm.yti.codelist.common.model;

import javax.xml.bind.annotation.XmlType;

import io.swagger.annotations.ApiModel;

@XmlType(propOrder = {"name", "email", "telephone"})
@ApiModel(value = "Organization", description = "Organization model that represents data for one single region.")
public class Organization {

    private String name;
    private String email;
    private String telephone;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }
}
