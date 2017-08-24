package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "updatestatus")
public class UpdateStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    private String m_id;

    private String m_status;

    private String m_dataType;

    private String m_source;

    private String m_version;

    private String m_nextVersion;

    private Date m_created;

    private Date m_modified;


    public UpdateStatus() {

    }


    @Id
    @Column(name = "id")
    public String getId() {
        return m_id;
    }

    public void setId(final String id) {
        m_id = id;
    }


    @Column(name = "status")
    public String getStatus() {
        return m_status;
    }

    public void setStatus(final String status) {
        m_status = status;
    }


    @Column(name = "datatype")
    public String getDataType() {
        return m_dataType;
    }

    public void setDataType(final String dataType) {
        m_dataType = dataType;
    }


    @Column(name = "version")
    public String getVersion() {
        return m_version;
    }

    public void setVersion(final String version) {
        m_version = version;
    }


    @ApiModelProperty(dataType = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
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


    @Column(name = "nextversion")
    public String getNextVersion() {
        return m_nextVersion;
    }

    public void setNextVersion(final String nextVersion) {
        m_nextVersion = nextVersion;
    }
}
