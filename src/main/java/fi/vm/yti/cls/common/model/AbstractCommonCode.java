package fi.vm.yti.cls.common.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


/**
 * Abstract common codevalue based entity class for object models in CLS domain.
 */
@MappedSuperclass
abstract class AbstractCommonCode extends AbstractBaseCode {

    private String m_codeValue;


    public AbstractCommonCode() {
    }


    @Column(name = "codevalue")
    public String getCodeValue() {
        return m_codeValue;
    }

    public void setCodeValue(final String codeValue) {
        m_codeValue = codeValue;
    }

}
