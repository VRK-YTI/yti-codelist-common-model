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

    private String m_nameFinnish;

    private String m_nameSwedish;

    private String m_nameEnglish;

    private String m_source;

    private Date m_created;

    private Date m_modified;

    private String m_url;

    private Map<String, String> m_names;

    private String m_status;


    public AbstractBaseCode() {

        m_names = new HashMap<>();

    }


    @Id
    @Column(name = "id", unique = true)
    public String getId() {
        return m_id;
    }

    public void setId(final String id) {
        m_id = id;
    }


    @JsonIgnore
    @Column(name = "name_fi")
    public String getNameFinnish() {
        return m_nameFinnish;
    }

    public void setNameFinnish(final String nameFinnish) {

        addName("fi", nameFinnish);
        m_nameFinnish = nameFinnish;

    }


    @JsonIgnore
    @Column(name = "name_se")
    public String getNameSwedish() {
        return m_nameSwedish;
    }

    public void setNameSwedish(final String nameSwedish) {

        addName("se", nameSwedish);
        m_nameSwedish = nameSwedish;

    }


    @JsonIgnore
    @Column(name = "name_en")
    public String getNameEnglish() {
        return m_nameEnglish;
    }

    public void setNameEnglish(final String nameEnglish) {

        addName("en", nameEnglish);
        m_nameEnglish = nameEnglish;

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


    @Column(name = "url")
    public String getUrl() {
        return m_url;
    }

    public void setUrl(final String url) {
        m_url = url;
    }


    @Column(name = "status")
    public String getStatus() {
        return m_status;
    }

    public void setStatus(final String status) {
        m_status = status;
    }


    @JsonProperty
    @Transient
    public Map<String, String> getNames() {

        return m_names;

    }


    private void addName(final String language, final String name) {

        if (language != null && name != null && !name.isEmpty()) {
            m_names.put(language, name);

        } else if (language != null && name == null) {
            m_names.remove(language);
        }

    }

}
