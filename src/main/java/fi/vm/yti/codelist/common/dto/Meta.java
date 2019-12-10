package fi.vm.yti.codelist.common.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;

@XmlType(propOrder = { "code", "message", "pageSize", "from", "resultCount", "totalResults", "after", "before", "afterResourceUrl", "nextPage" })
@Schema(name = "Meta", description = "Meta information model for API responses.")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Meta {

    private Integer code;
    private String message;
    private Integer pageSize;
    private Integer from;
    private Integer resultCount;
    private Integer totalResults;
    private Date after;
    private Date before;
    private String afterResourceUrl;
    private String nextPage;
    private String entityIdentifier;
    private String nonTranslatableMessage;

    public Meta() {
    }

    public Meta(final Integer code,
                final Integer pageSize,
                final Integer from,
                final Date after,
                final Date before) {
        this.code = code;
        this.pageSize = pageSize;
        this.from = from;
        this.after = after;
        this.before = before;
    }

    public Meta(final Integer code,
                final Integer pageSize,
                final Integer from,
                final Date after,
                final Date before,
                final String entityIdentifier) {
        this.code = code;
        this.pageSize = pageSize;
        this.from = from;
        this.after = after;
        this.before = before;
        this.entityIdentifier = entityIdentifier;
    }

    public Meta(final Integer code,
                final Integer pageSize,
                final Integer from,
                final Date after,
                final Date before,
                final String entityIdentifier,
                final String nonTranslatableMessage) {
        this.code = code;
        this.pageSize = pageSize;
        this.from = from;
        this.after = after;
        this.before = before;
        this.entityIdentifier = entityIdentifier;
        this.nonTranslatableMessage = nonTranslatableMessage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(final Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(final Integer from) {
        this.from = from;
    }

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(final Integer resultCount) {
        this.resultCount = resultCount;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(final Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Date getAfter() {
        if (after != null) {
            return new Date(after.getTime());
        }
        return null;
    }

    public void setAfter(final Date after) {
        if (after != null) {
            this.after = new Date(after.getTime());
        } else {
            this.after = null;
        }
    }

    public Date getBefore() {
        if (before != null) {
            return new Date(before.getTime());
        }
        return null;
    }

    public void setBefore(final Date before) {
        if (before != null) {
            this.before = new Date(before.getTime());
        } else {
            this.before = null;
        }
    }

    public String getAfterResourceUrl() {
        return afterResourceUrl;
    }

    public void setAfterResourceUrl(final String afterResourceUrl) {
        this.afterResourceUrl = afterResourceUrl;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(final String nextPage) {
        this.nextPage = nextPage;
    }

    public String getEntityIdentifier() {
        return entityIdentifier;
    }

    public void setEntityIdentifier(String entityIdentifier) {
        this.entityIdentifier = entityIdentifier;
    }

    public String getNonTranslatableMessage() {
        return nonTranslatableMessage;
    }

    public void setNonTranslatableMessage(final String nonTranslatableMessage) {
        this.nonTranslatableMessage = nonTranslatableMessage;
    }
}
