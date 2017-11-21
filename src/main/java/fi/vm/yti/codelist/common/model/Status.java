package fi.vm.yti.codelist.common.model;

/**
 * These are ISO 19135-1 spec status codes for registry status.
 *
 * @see <a href="http://inspire.ec.europa.eu/registry/status">http://inspire.ec.europa.eu/registry/status</a>
 */
public enum Status {

    INVALID("Invalid", "A decision has been made that a previously valid register item contains a substantial error and is invalid, and will normally have been replaced by a corrected item."),
    VALID("Valid", "The item has been accepted, is recommended for use, and has not been superseded or retired."),
    SUPERSEDED("Superseded", "The item has been superseded by another item and is no longer recommended for use."),
    RETIRED("Retired", "A decision has been made that the item is no longer recommended for use. It has not been superseded by another item."),
    DRAFT("Dreft", "A draft state item."),
    SUBMITTED("Submitted", "The item has been entered into the register, but the control body has not accepted the proposal to add it.");

    private String name;
    private String description;

    Status(final String name,
           final String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
