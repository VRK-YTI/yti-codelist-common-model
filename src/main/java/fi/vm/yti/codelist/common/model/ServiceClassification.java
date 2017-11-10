package fi.vm.yti.codelist.common.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonFilter("serviceClassification")
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ServiceClassification extends Code {

    private static final long serialVersionUID = 1L;

    public ServiceClassification() {
    }

    public ServiceClassification(final Code code, final Integer count) {
        super.setCodeScheme(code.getCodeScheme());
        super.setCodeValue(code.getCodeValue());
        super.setPrefLabels(code.getPrefLabels());
        setCount(count);
    }

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(final Integer count) {
        this.count = count;
    }
}
