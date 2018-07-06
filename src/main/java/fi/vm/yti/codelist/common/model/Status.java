package fi.vm.yti.codelist.common.model;

/**
 * These are ISO 19135-1 spec status codes with added service specific draft and suggested statuses.
 *
 * @see <a href="http://inspire.ec.europa.eu/registry/status">http://inspire.ec.europa.eu/registry/status</a>
 */
public enum Status {

    UNFINISHED,
    DRAFT,
    SUBMITTED,
    SUGGESTED,
    VALID,
    SUPERSEDED,
    RETIRED,
    INVALID;

    Status() {
    }
}
