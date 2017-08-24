package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;


/**
 * Object model that represents a street address entity.
 */
@Entity
@JsonFilter("streetAddress")
@Table(name = "streetaddress")
@NamedEntityGraph(name = "streetAddressListing",
        attributeNodes = {
            @NamedAttributeNode(value = "url"),
            @NamedAttributeNode(value = "municipality", subgraph = "municipality"),
            @NamedAttributeNode(value = "streetNumbers", subgraph = "streetNumbers")
        },
        subgraphs = {
            @NamedSubgraph(name = "streetNumbers",
                    type = StreetNumber.class,
                    attributeNodes = {
                            @NamedAttributeNode("url"),
                            @NamedAttributeNode(value = "postalCode", subgraph = "postalCode"),
                            @NamedAttributeNode(value = "streetAddress", subgraph = "streetAddress")
                    }
            ),
            @NamedSubgraph(name = "municipality",
                    type = Municipality.class,
                    attributeNodes = {
                            @NamedAttributeNode("url")
                    }
            )
        },
        subclassSubgraphs = {
                @NamedSubgraph(name = "postalCode",
                        type = PostalCode.class,
                        attributeNodes = {
                                @NamedAttributeNode("url")
                        }
                ),
                @NamedSubgraph(name = "streetAddress",
                        type = StreetAddress.class,
                        attributeNodes = {
                                @NamedAttributeNode("url")
                        }
                )
        }
)
@XmlType(propOrder = { "url", "id", "source", "status", "created", "modified", "names", "municipality", "streetNumbers" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(value = { "code" })
@ApiModel(value = "StreetAddress", description = "StreetAddress model that represents data for one single streetaddress.")
public class StreetAddress extends AbstractBaseCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private Municipality m_municipality;

    private List<StreetNumber> m_streetNumbers;


    public StreetAddress() {

    }


    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "municipality_id")
    public Municipality getMunicipality() {
        return m_municipality;
    }

    public void setMunicipality(final Municipality municipality) {
        m_municipality = municipality;
    }


    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "streetAddress")
    public List<StreetNumber> getStreetNumbers() {
        return m_streetNumbers;
    }

    public void setStreetNumbers(final List<StreetNumber> streetNumbers) {
        m_streetNumbers = streetNumbers;
    }


    public String toString() {
        return "(" +
                "m_url: " + getUrl() + ", " +
                "m_source: " + getSource() + ", " +
                "m_status: " + getStatus() + ", " +
                "m_created: " + getCreated() + ", " +
                "m_modified: " + getModified() + ", " +
                "m_names: " + getNames() + ")";
    }

}
