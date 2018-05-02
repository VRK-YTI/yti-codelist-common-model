package fi.vm.yti.codelist.common.dto;

import java.io.Serializable;

public class ErrorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private int httpStatusCode;
    private String message;

    private String entityIdentifier;

    public ErrorModel(int httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }

    public ErrorModel(int httpStatusCode, String message, String entityIdentifier) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
        this.entityIdentifier = entityIdentifier;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getEntityIdentifier() {
        return entityIdentifier;
    }

    public void setEntityIdentifier(String entityIdentifier) {
        this.entityIdentifier = entityIdentifier;
    }
}
