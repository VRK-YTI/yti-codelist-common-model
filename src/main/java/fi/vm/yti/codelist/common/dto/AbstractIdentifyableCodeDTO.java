package fi.vm.yti.codelist.common.dto;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;

import fi.vm.yti.codelist.common.util.Identifiable;

@MappedSuperclass
public class AbstractIdentifyableCodeDTO implements Identifiable {

    private UUID id;

    @Id
    @JsonView(Views.Normal.class)
    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }
}
