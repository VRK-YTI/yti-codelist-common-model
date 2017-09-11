package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Object model that represents a postmanagementdistrict entity.
 */
@Entity
@JsonFilter("postManagementDistrict")
@Table(name ="postmanagementdistrict")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "codeValue", scope = PostManagementDistrict.class)
@Proxy(lazy = false)
@XmlRootElement
@XmlType(propOrder = { "codeValue", "uri", "id", "source", "status", "modified", "prefLabels", "postalCodes"})
@JsonIgnoreProperties(value = { "postalCodes" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "PostManagementDistrict", description = "PostManagementDistrict model that represents data for one single post management district.")
public class PostManagementDistrict extends AbstractLabeledCommonCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<PostalCode> postalCodes;

    public PostManagementDistrict() {}

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "postmanagementdistrict_id", nullable = true)
    public List<PostalCode> getPostalCodes() {
        return postalCodes;
    }

    public void setPostalCodes(final List<PostalCode> postalCodes) {
        this.postalCodes = postalCodes;
    }

    public String toString() {
        return "(" +
                "codeValue: " + getCodeValue() + ", " +
                "url: " + getUri() + ", " +
                "source: " + getSource() + ", " +
                "status: " + getStatus() + ", " +
                "status: " + getStatus() + ", " +
                "modified: " + getModified() + ", " +
                "prefLabels: " + getPrefLabels() + ")";
    }

}
