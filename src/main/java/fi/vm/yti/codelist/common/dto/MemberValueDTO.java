package fi.vm.yti.codelist.common.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonFilter("memberValue")
@XmlRootElement
@XmlType(propOrder = { "id", "value", "valueType", "member", "created", "modified" })
@Schema(name = "ValueType", description = "ValueType DTO for value typing.")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MemberValueDTO extends AbstractIdentifyableCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String value;
    private Date created;
    private Date modified;
    private ValueTypeDTO valueType;
    private MemberDTO member;

    @JsonView(Views.Normal.class)

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    @Schema(format = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @JsonView(Views.Normal.class)
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

    @Schema(format = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @JsonView(Views.Normal.class)
    public Date getCreated() {
        if (created != null) {
            return new Date(created.getTime());
        }
        return null;
    }

    public void setCreated(final Date created) {
        if (created != null) {
            this.created = new Date(created.getTime());
        } else {
            this.created = null;
        }
    }

    @JsonView(Views.Normal.class)
    public ValueTypeDTO getValueType() {
        return valueType;
    }

    public void setValueType(final ValueTypeDTO valueType) {
        this.valueType = valueType;
    }

    @JsonView(Views.Normal.class)
    public MemberDTO getMember() {
        return member;
    }

    public void setMember(final MemberDTO member) {
        this.member = member;
    }
}
