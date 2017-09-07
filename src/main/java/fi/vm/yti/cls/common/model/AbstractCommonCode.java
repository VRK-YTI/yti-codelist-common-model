package fi.vm.yti.cls.common.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Abstract common codevalue based entity class for object models in CLS domain.
 */
@MappedSuperclass
abstract class AbstractCommonCode extends AbstractBaseCode {

    private String codeValue;

    public AbstractCommonCode() {}

    @Column(name = "codevalue")
    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(final String codeValue) {
        this.codeValue = codeValue;
    }

}
