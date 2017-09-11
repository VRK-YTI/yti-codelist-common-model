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
@XmlType(propOrder = { "codeValue", "uri", "detailsUri", "id", "source", "status", "modified", "prefLabels", "companyForm" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "BusinessId", description = "BusinessId model that represents data for one single businessId.")
public class BusinessId extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String companyForm;
    private String detailsUri;

    public BusinessId() {
    }

    @Column(name = "companyform")
    public String getCompanyForm() {
        return companyForm;
    }

    public void setCompanyForm(final String companyForm) {
        this.companyForm = companyForm;
    }

    @Column(name = "detailsuri")
    public String getDetailsUri() {
        return detailsUri;
    }

    public void setDetailsUri(final String detailsUri) {
        this.detailsUri = detailsUri;
    }

    public String toString() {
        return "(" +
                "code: " + getCodeValue() + ", " +
                "uri: " + getUri() + ", " +
                "detailsUri: " + getDetailsUri() + ", " +
                "source: " + getSource() + ", " +
                "status: " + getStatus() + ", " +
                "modified: " + getModified() + ", " +
                "prefLabels: " + getPrefLabels() + ", " +
                "companyForm: " + getCompanyForm() + ")";
    }

}
