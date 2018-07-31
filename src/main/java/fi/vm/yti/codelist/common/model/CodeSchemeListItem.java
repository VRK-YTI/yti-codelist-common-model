package fi.vm.yti.codelist.common.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * This class exists only for the needs of the front-end.
 * It always represents a codescheme but it could be a variant or a version.
 */
public class CodeSchemeListItem implements Serializable {
    private Map<String, String> prefLabel;
    private String uri;
    private Date startDate;
    private Date endDate;
    private String status;

    public CodeSchemeListItem() {}

    public CodeSchemeListItem(Map<String, String> prefLabel, String uri, Date startDate, Date endDate, String status) {
        this.prefLabel = prefLabel;
        this.uri = uri;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Map<String, String> getPrefLabel() {
        return prefLabel;
    }

    public void setPrefLabel(final Map<String, String> prefLabel) {
        this.prefLabel = prefLabel;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}
