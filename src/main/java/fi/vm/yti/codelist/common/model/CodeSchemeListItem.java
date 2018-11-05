package fi.vm.yti.codelist.common.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import fi.vm.yti.codelist.common.dto.Views;
import fi.vm.yti.codelist.common.util.Identifiable;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class exists only for the needs of the front-end.
 * It always represents a codescheme but it could be a variant or a version.
 */
public class CodeSchemeListItem implements Serializable, Identifiable {

    private UUID id;
    private Map<String, String> prefLabel;
    private String uri;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    public CodeSchemeListItem() {
    }

    public CodeSchemeListItem(final UUID id,
                              final Map<String, String> prefLabel,
                              final String uri,
                              final LocalDate startDate,
                              final LocalDate endDate,
                              final String status) {
        this.id = id;
        this.prefLabel = prefLabel;
        this.uri = uri;
        if (startDate != null) {
            this.startDate = startDate;
        }
        if (endDate != null) {
            this.endDate = endDate;
        }
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

    @ApiModelProperty(dataType = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @JsonView({ Views.Normal.class })
    public LocalDate getStartDate() {
        if (startDate != null) {
            return startDate;
        }
        return null;
    }

    public void setStartDate(final LocalDate startDate) {
        if (startDate != null) {
            this.startDate = startDate;
        } else {
            this.startDate = null;
        }
    }

    @ApiModelProperty(dataType = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @JsonView({ Views.Normal.class })
    public LocalDate getEndDate() {
        if (endDate != null) {
            return endDate;
        }
        return null;
    }

    public void setEndDate(final LocalDate endDate) {
        if (endDate != null) {
            this.endDate = endDate;
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
