package fi.vm.yti.codelist.common.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Abstract common codevalue based entity class for object models in CLS domain.
 */
@MappedSuperclass
abstract class AbstractCommonCode extends AbstractBaseCode {

    private String codeValue;

    @Column(name = "codevalue")
    @JsonView(Views.Normal.class)
    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(final String codeValue) {
        this.codeValue = codeValue;
    }
}
