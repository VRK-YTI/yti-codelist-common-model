package fi.vm.yti.codelist.common.model;

/**
 * These are ISO 19135-1 spec status codes for registry status. Service with an added service specific draft status.
 *
 * @see <a href="http://inspire.ec.europa.eu/registry/status">http://inspire.ec.europa.eu/registry/status</a>
 */
public enum Status {

    INVALID,
    VALID,
    SUPERSEDED,
    RETIRED,
    DRAFT,
    SUBMITTED;

    Status() {
    }
}
