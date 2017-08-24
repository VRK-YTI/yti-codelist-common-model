package fi.vm.yti.cls.common.model;


/**
 * Enumeration for postoffice types.
 */
public enum PostOfficeType {

    NORMALPOST(0, "Normaaliposti-numero"),
    POSTILOKERO(1, "Postilokero-postinumero"),
    YRITYSPOSTI(2, "Yritysposti-numero"),
    KOONTIPALVELU(3, "Koontipalvelu-postinumero"),
    VASTAUSLÄHETYS(4, "Vastauslähetys-postinumero"),
    SMARTPOST(5, "SmartPOST (pakettiautomaatti)"),
    NOUTOPISTE(6, "Noutopiste"),
    TEKNINEN(7, "Tekninen postinumero");

    private final int m_value;

    private final String m_name;


    PostOfficeType(final int value, final String name) {
        m_value = value;
        m_name = name;
    }


    public int getValue() {
        return m_value;
    }


    public String getName() {
        return m_name;
    }


    static final PostOfficeType TYPES[] = values();


    public static PostOfficeType valueOf(final int value) {
        if (value >= 0 && value < TYPES.length) {
            return TYPES[value];
        }
        return null;
    }

}