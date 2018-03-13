package fi.vm.yti.codelist.common.dto;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class AbstractCommonCodeDTO extends AbstractBaseCodeDTO {

    private String codeValue;

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(final String codeValue) {
        this.codeValue = codeValue;
    }
}
