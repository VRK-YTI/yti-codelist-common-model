package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Abstract common base class for object models in CLS domain.
 */
@MappedSuperclass
public class AbstractBaseCode {

    private String m_id;

    private String m_source;

    private Date m_created;

    private Date m_modified;

    private Date m_startDate;

    private Date m_endDate;

    private String m_uri;

    private String m_status;


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
    @Column(name = "startdate")
    public Date getStartDate() {
        if (m_startDate != null) {
            return new Date(m_startDate.getTime());
        }
        return null;

    }

    public void setStartDate(final Date startDate) {

        if (startDate != null) {
            m_startDate = new Date(startDate.getTime());
        } else {
            m_startDate = null;
        }

    }


    @ApiModelProperty(dataType = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "enddate")
    public Date getEndDate() {

        if (m_endDate != null) {
            return new Date(m_endDate.getTime());
        }
        return null;

    }

    public void setEndDate(final Date endDate) {

        if (endDate != null) {
            m_endDate = new Date(endDate.getTime());
        } else {
            m_endDate = null;
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


    @Column(name = "status")
    public String getStatus() {
        return m_status;
    }

    public void setStatus(final String status) {
        m_status = status;
    }

}
