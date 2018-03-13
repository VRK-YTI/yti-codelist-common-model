package fi.vm.yti.codelist.common.dto;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;

import fi.vm.yti.codelist.common.model.Views;

@MappedSuperclass
abstract class AbstractCommonCodeDTO extends AbstractBaseCodeDTO {

    private String codeValue;

    @JsonView(Views.Normal.class)
    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(final String codeValue) {
        this.codeValue = codeValue;
    }
}
