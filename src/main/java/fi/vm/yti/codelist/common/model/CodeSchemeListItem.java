package fi.vm.yti.codelist.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import fi.vm.yti.codelist.common.dto.Views;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * This class exists only for the needs of the front-end.
 * It always represents a codescheme but it could be a variant or a version.
 */
public class CodeSchemeListItem implements Serializable {
    private UUID id;
    private Map<String, String> prefLabel;
    private String uri;
    private Date startDate;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CodeSchemeListItem listItem = (CodeSchemeListItem) o;
        return Objects.equals(id,
                listItem.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    private Date endDate;
    private String status;

    public CodeSchemeListItem() {}

    public CodeSchemeListItem(UUID id,Map<String, String> prefLabel, String uri, Date startDate, Date endDate, String status) {
        this.id = id;
        this.prefLabel = prefLabel;
        this.uri = uri;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
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

    @ApiModelProperty(
            dataType = "dateTime"
    )
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    @Temporal(TemporalType.DATE)
    @JsonView({Views.Normal.class})
    public Date getStartDate() {
        if (startDate != null) {
            return new Date(startDate.getTime());
        }
        return null;
    }

    public void setStartDate(final Date startDate) {
        if (startDate != null) {
            this.startDate = new Date(startDate.getTime());
        } else {
            this.startDate = null;
        }
    }

    @ApiModelProperty(
            dataType = "dateTime"
    )
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    @Temporal(TemporalType.DATE)
    @JsonView({Views.Normal.class})
    public Date getEndDate() {
        if (endDate != null) {
            return new Date(endDate.getTime());
        }
        return null;
    }

    public void setEndDate(final Date endDate) {
        if (endDate != null) {
            this.endDate = new Date(endDate.getTime());
        } else {
            this.endDate = null;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}
