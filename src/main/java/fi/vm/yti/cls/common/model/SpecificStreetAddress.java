package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "url", "id", "source", "status", "created", "modified", "names", "number", "character", "postalCode" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "SpecificStreetAddress", description = "StreetAddress model that represents data for a street address with a specific street number.")
public class SpecificStreetAddress extends StreetAddress {

    private Integer m_number;

    private String m_character;

    private PostalCode m_postalCode;


    public SpecificStreetAddress() {

    }

    public SpecificStreetAddress(final StreetAddress streetAddress) {

        final String nameFinnish = streetAddress.getNames().get("fi");
        final String nameSwedish = streetAddress.getNames().get("se");
        setNameFinnish(nameFinnish);
        setNameSwedish(nameSwedish);
        setCreated(streetAddress.getCreated());
        setModified(streetAddress.getModified());
        setMunicipality(streetAddress.getMunicipality());

    }


    public Integer getNumber() {
        return m_number;
    }

    public void setNumber(final Integer number) {
        m_number = number;
    }


    public String getCharacter() {
        return m_character;
    }

    public void setCharacter(final String character) {
        m_character = character;
    }


    public PostalCode getPostalCode() {
        return m_postalCode;
    }

    public void setPostalCode(final PostalCode postalCode) {
        m_postalCode = postalCode;
    }


}
