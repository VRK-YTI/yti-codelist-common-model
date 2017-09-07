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

    private final int value;

    private final String name;

    PostOfficeType(final int value, final String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    static final PostOfficeType TYPES[] = values();

    public static PostOfficeType valueOf(final int value) {
        if (value >= 0 && value < TYPES.length) {
            return TYPES[value];
        }
        return null;
    }

}