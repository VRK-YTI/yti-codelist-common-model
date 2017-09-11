package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "uri", "id", "source", "status", "modified", "prefLabels", "number", "character", "postalCode" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ApiModel(value = "SpecificStreetAddress", description = "StreetAddress model that represents data for a street address with a specific street number.")
public class SpecificStreetAddress extends StreetAddress {

    private static final long serialVersionUID = 1L;

    private Integer number;
    private String character;
    private PostalCode postalCode;

    public SpecificStreetAddress() {}

    public SpecificStreetAddress(final StreetAddress streetAddress) {
        final String nameFinnish = streetAddress.getPrefLabels().get("fi");
        final String nameSwedish = streetAddress.getPrefLabels().get("se");
        setPrefLabelFi(nameFinnish);
        setPrefLabelSe(nameSwedish);
        setModified(streetAddress.getModified());
        setMunicipality(streetAddress.getMunicipality());
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(final Integer number) {
        this.number = number;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(final String character) {
        this.character = character;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final PostalCode postalCode) {
        this.postalCode = postalCode;
    }

}
