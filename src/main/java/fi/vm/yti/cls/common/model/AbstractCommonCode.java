package fi.vm.yti.cls.common.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Abstract common base class for object models in CLS domain.
 */
@MappedSuperclass
abstract class AbstractCommonCode extends AbstractBaseCode {

    private String m_code;


    public AbstractCommonCode() {
    }


    @Column(name = "code", unique = true)
    public String getCode() {
        return m_code;
    }

    public void setCode(final String code) {
        m_code = code;
    }

}
