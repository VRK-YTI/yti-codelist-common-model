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
@XmlType(propOrder = { "codeValue", "uri", "detailsUri", "id", "source", "status", "created", "modified", "prefLabels", "companyForm" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "BusinessId", description = "BusinessId model that represents data for one single businessId.")
public class BusinessId extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String m_companyForm;

    private String m_detailsUri;


    public BusinessId() {
    }


    @Column(name = "companyform")
    public String getCompanyForm() {
        return m_companyForm;
    }

    public void setCompanyForm(final String companyForm) {
        this.m_companyForm = companyForm;
    }


    @Column(name = "detailsuri")
    public String getDetailsUri() {
        return m_detailsUri;
    }

    public void setDetailsUri(final String detailsUri) {
        m_detailsUri = detailsUri;
    }


    public String toString() {
        return "(" +
                "m_code: " + getCodeValue() + ", " +
                "m_uri: " + getUri() + ", " +
                "m_detailsUri: " + getDetailsUri() + ", " +
                "m_source: " + getSource() + ", " +
                "m_status: " + getStatus() + ", " +
                "m_created: " + getCreated() + ", " +
                "m_modified: " + getModified() + ", " +
                "m_prefLabels: " + getPrefLabels() + ", " +
                "m_companyForm: " + getCompanyForm() + ")";
    }

}
