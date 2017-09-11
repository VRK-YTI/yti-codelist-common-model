package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

/**
 * Object model that represents a street address number entity.
 */
@Entity
@JsonFilter("streetNumber")
@Table(name = "streetnumber")
@XmlType(propOrder = { "uri", "id", "source", "status", "modified", "postalCode", "streetAddress", "isEven", "startNumber", "startCharacter", "startNumberEnd", "startCharacterEnd", "endNumber", "endCharacter", "endNumberEnd", "endCharacterEnd" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "StreetNumber", description = "StreetNumber model that represents data for specific streetnumbering.")
public class StreetNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String source;
    private Date modified;
    private String uri;
    private PostalCode postalCode;
    private StreetAddress streetAddress;
    private boolean isEven;
    private Integer startNumber;
    private String startCharacter;
    private Integer startNumberEnd;
    private String startCharacterEnd;
    private String endCharacter;
    private Integer endNumber;
    private String endCharacterEnd;
    private Integer endNumberEnd;
    private String status;
    
    public StreetNumber() {}
    
    @Id
    @Column(name = "id", unique = true)
    public String getId() {
        return id;
    }
    public void setId(final String id) {
        this.id = id;
    }
    
    @ApiModelProperty(dataType = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified")
    public Date getModified() {
        if (modified != null) {
            return new Date(modified.getTime());
        }
        return null;
    }

    public void setModified(final Date modified) {
        if (modified != null) {
            this.modified = new Date(modified.getTime());
        } else {
            this.modified = null;
        }
    }

    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(final String source) {
        this.source = source;
    }

    @Column(name = "uri")
    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "streetaddress_id", nullable = true)
    public StreetAddress getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(final StreetAddress streetAddress) {
        this.streetAddress = streetAddress;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    @JoinColumn(name = "postalcode_id")
    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final PostalCode postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "iseven")
    public boolean getIsEven() {
        return isEven;
    }

    public void setIsEven(final boolean isEven) {
        this.isEven = isEven;
    }

    @Column(name = "startnumber")
    public Integer getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(final Integer startNumber) {
        this.startNumber = startNumber;
    }

    @Column(name = "endnumber")
    public Integer getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(final Integer endNumber) {
        this.endNumber = endNumber;
    }

    @Column(name = "startnumberend")
    public Integer getStartNumberEnd() {
        return startNumberEnd;
    }

    public void setStartNumberEnd(final Integer startNumberEnd) {
        this.startNumberEnd = startNumberEnd;
    }

    @Column(name = "endnumberend")
    public Integer getEndNumberEnd() {
        return endNumberEnd;
    }

    public void setEndNumberEnd(final Integer endNumberEnd) {
        this.endNumberEnd = endNumberEnd;
    }

    @Column(name = "startcharacter")
    public String getStartCharacter() {
        return startCharacter;
    }

    public void setStartCharacter(final String startCharacter) {
        this.startCharacter = startCharacter;
    }

    @Column(name = "endcharacter")
    public String getEndCharacter() {
        return endCharacter;
    }

    public void setEndCharacter(final String endCharacter) {
        this.endCharacter = endCharacter;
    }

    @Column(name = "startcharacterend")
    public String getStartCharacterEnd() {
        return startCharacterEnd;
    }

    public void setStartCharacterEnd(final String startCharacterEnd) {
        this.startCharacterEnd = startCharacterEnd;
    }

    @Column(name = "endcharacterend")
    public String getEndCharacterEnd() {
        return endCharacterEnd;
    }

    public void setEndCharacterEnd(final String endCharacterEnd) {
        this.endCharacterEnd = endCharacterEnd;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public boolean hasNumber(final int number) {
        if (number % 2 == 0 && isEven || number % 2 != 0 && !isEven) {
            // End number with ending
            if (endNumberEnd != null && number >= startNumber && number <= endNumberEnd) {
                return true;
            // End number
            } else if (endNumber != null && number >= startNumber && number <= endNumber) {
                return true;
            // Start number with ending
            } else if (startNumberEnd != null && number >= startNumber && number <= startNumberEnd) {
                return true;
            // Start number
            } else if (number == startNumber) {
                return true;
            }
        }
        return false;
    }

}
