package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import io.swagger.annotations.ApiModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlType;
import java.text.ParseException;
import java.util.Date;

@XmlType(propOrder = { "code", "message", "register", "pageSize", "from", "resultCount", "totalResults", "after", "afterResourceUrl", "nextPage" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "Meta", description = "Meta information model for API responses.")
public class Meta {

    private static final Logger LOG = LoggerFactory.getLogger(Meta.class);

    private Integer m_code;

    private String m_message;

    private Register m_register;

    private Integer m_pageSize;

    private Integer m_from;

    private Integer m_resultCount;

    private Integer m_totalResults;

    private Date m_after;

    private String m_afterResourceUrl;

    private String m_nextPage;

    public Meta() {

    }

    public Meta(final Integer code,
                final Integer pageSize,
                final Integer from,
                final String after) {

        m_code = code;

        m_pageSize = pageSize;

        m_from = from;

        m_after = parseAfterFromString(after);

    }


    public Integer getCode() {
        return m_code;
    }

    public void setCode(final Integer code) {
        m_code = code;
    }

    public String getMessage() {
        return m_message;
    }

    public void setMessage(final String message) {
        m_message = message;
    }

    public Integer getPageSize() {
        return m_pageSize;
    }

    public void setPageSize(final Integer pageSize) {
        m_pageSize = pageSize;
    }

    public Integer getFrom() {
        return m_from;
    }

    public void setFrom(final Integer from) {
        m_from = from;
    }

    public Integer getResultCount() {
        return m_resultCount;
    }

    public void setResultCount(final Integer resultCount) {
        m_resultCount = resultCount;
    }

    public Integer getTotalResults() {
        return m_totalResults;
    }

    public void setTotalResults(final Integer totalResults) {
        m_totalResults = totalResults;
    }

    public Date getAfter() {

        if (m_after != null) {
            return new Date(m_after.getTime());
        }
        return null;

    }

    public void setAfter(final Date after) {

        if (after != null) {
            m_after = new Date(after.getTime());
        } else {
            m_after = null;
        }

    }

    public String getAfterResourceUrl() {
        return m_afterResourceUrl;
    }

    public void setAfterResourceUrl(final String afterResourceUrl) {
        m_afterResourceUrl = afterResourceUrl;
    }


    public String getNextPage() {
        return m_nextPage;
    }

    public void setNextPage(final String nextPage) {
        m_nextPage = nextPage;
    }


    public Register getRegister() {
        return m_register;
    }

    public void setRegister(final Register register) {
        m_register = register;
    }


    public Date parseAfterFromString(final String after) {

        if (after != null) {
            final ISO8601DateFormat dateFormat = new ISO8601DateFormat();
            try {
                return dateFormat.parse(after);
            } catch (ParseException e) {
                LOG.error("Parsing date from string failed: " + e.getMessage());
            }
        }

        return null;

    }

}
