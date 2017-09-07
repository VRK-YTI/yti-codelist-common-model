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
@XmlType(propOrder = { "uri", "id", "source", "status", "created", "modified", "postalCode", "streetAddress", "isEven", "startNumber", "startCharacter", "startNumberEnd", "startCharacterEnd", "endNumber", "endCharacter", "endNumberEnd", "endCharacterEnd" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "StreetNumber", description = "StreetNumber model that represents data for specific streetnumbering.")
public class StreetNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    private String m_id;

    private String m_source;

    private Date m_created;

    private Date m_modified;

    private String m_uri;

    private PostalCode m_postalCode;

    private StreetAddress m_streetAddress;

    private boolean m_isEven;

    private Integer m_startNumber;

    private String m_startCharacter;

    private Integer m_startNumberEnd;

    private String m_startCharacterEnd;

    private String m_endCharacter;

    private Integer m_endNumber;

    private String m_endCharacterEnd;

    private Integer m_endNumberEnd;

    private String m_status;


    public StreetNumber() {

    }


    @Id
    @Column(name = "id", unique = true)
    public String getId() {
        return m_id;
    }

    public void setId(final String id) {
        m_id = id;
    }


    @ApiModelProperty(dataType = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    public Date getCreated() {

        if (m_created != null) {
            return new Date(m_created.getTime());
        }
        return null;

    }

    public void setCreated(final Date created) {

        if (created != null) {
            m_created = new Date(created.getTime());
        } else {
            m_created = null;
        }

    }


    @ApiModelProperty(dataType = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified")
    public Date getModified() {

        if (m_modified != null) {
            return new Date(m_modified.getTime());
        }
        return null;

    }

    public void setModified(final Date modified) {

        if (modified != null) {
            m_modified = new Date(modified.getTime());
        } else {
            m_modified = null;
        }

    }


    @Column(name = "source")
    public String getSource() {
        return m_source;
    }

    public void setSource(final String source) {
        m_source = source;
    }


    @Column(name = "uri")
    public String getUri() {
        return m_uri;
    }

    public void setUri(final String uri) {
        m_uri = uri;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "streetaddress_id", nullable = true)
    public StreetAddress getStreetAddress() {
        return m_streetAddress;
    }

    public void setStreetAddress(final StreetAddress streetAddress) {
        m_streetAddress = streetAddress;
    }


    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    @JoinColumn(name = "postalcode_id")
    public PostalCode getPostalCode() {
        return m_postalCode;
    }

    public void setPostalCode(final PostalCode postalCode) {
        m_postalCode = postalCode;
    }


    @Column(name = "iseven")
    public boolean getIsEven() {
        return m_isEven;
    }

    public void setIsEven(final boolean isEven) {
        m_isEven = isEven;
    }


    @Column(name = "startnumber")
    public Integer getStartNumber() {
        return m_startNumber;
    }

    public void setStartNumber(final Integer startNumber) {
        m_startNumber = startNumber;
    }


    @Column(name = "endnumber")
    public Integer getEndNumber() {
        return m_endNumber;
    }

    public void setEndNumber(final Integer endNumber) {
        m_endNumber = endNumber;
    }

    @Column(name = "startnumberend")
    public Integer getStartNumberEnd() {
        return m_startNumberEnd;
    }

    public void setStartNumberEnd(final Integer startNumberEnd) {
        m_startNumberEnd = startNumberEnd;
    }


    @Column(name = "endnumberend")
    public Integer getEndNumberEnd() {
        return m_endNumberEnd;
    }

    public void setEndNumberEnd(final Integer endNumberEnd) {
        m_endNumberEnd = endNumberEnd;
    }


    @Column(name = "startcharacter")
    public String getStartCharacter() {
        return m_startCharacter;
    }

    public void setStartCharacter(final String startCharacter) {
        m_startCharacter = startCharacter;
    }


    @Column(name = "endcharacter")
    public String getEndCharacter() {
        return m_endCharacter;
    }

    public void setEndCharacter(final String endCharacter) {
        m_endCharacter = endCharacter;
    }


    @Column(name = "startcharacterend")
    public String getStartCharacterEnd() {
        return m_startCharacterEnd;
    }

    public void setStartCharacterEnd(final String startCharacterEnd) {
        m_startCharacterEnd = startCharacterEnd;
    }


    @Column(name = "endcharacterend")
    public String getEndCharacterEnd() {
        return m_endCharacterEnd;
    }

    public void setEndCharacterEnd(final String endCharacterEnd) {
        m_endCharacterEnd = endCharacterEnd;
    }


    @Column(name = "status")
    public String getStatus() {
        return m_status;
    }

    public void setStatus(final String status) {
        m_status = status;
    }


    public boolean hasNumber(final int number) {
        if (number % 2 == 0 && m_isEven || number % 2 != 0 && !m_isEven) {
            // End number with ending
            if (m_endNumberEnd != null && number >= m_startNumber && number <= m_endNumberEnd) {
                return true;
            // End number
            } else if (m_endNumber != null && number >= m_startNumber && number <= m_endNumber) {
                return true;
            // Start number with ending
            } else if (m_startNumberEnd != null && number >= m_startNumber && number <= m_startNumberEnd) {
                return true;
            // Start number
            } else if (number == m_startNumber) {
                return true;
            }
        }
        return false;
    }

}
