package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * Object model that represents a business id entity.
 */
@Entity
@JsonFilter("businessId")
@Table(name = "businessid")
@XmlType(propOrder = { "code", "url", "detailsUrl", "id", "source", "status", "created", "modified", "names", "companyForm" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "BusinessId", description = "BusinessId model that represents data for one single businessId.")
public class BusinessId extends AbstractCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String m_companyForm;

    private String m_detailsUrl;


    public BusinessId() {
    }


    @Column(name = "companyform")
    public String getCompanyForm() {
        return m_companyForm;
    }

    public void setCompanyForm(final String companyForm) {
        this.m_companyForm = companyForm;
    }


    @Column(name = "detailsurl")
    public String getDetailsUrl() {
        return m_detailsUrl;
    }

    public void setDetailsUrl(final String detailsUrl) {
        m_detailsUrl = detailsUrl;
    }


    public String toString() {
        return "(" +
                "m_code: " + getCode() + ", " +
                "m_url: " + getUrl() + ", " +
                "m_detailsUrl: " + getDetailsUrl() + ", " +
                "m_source: " + getSource() + ", " +
                "m_status: " + getStatus() + ", " +
                "m_created: " + getCreated() + ", " +
                "m_modified: " + getModified() + ", " +
                "m_names: " + getNames() + ", " +
                "m_companyForm: " + getCompanyForm() + ")";
    }

}
