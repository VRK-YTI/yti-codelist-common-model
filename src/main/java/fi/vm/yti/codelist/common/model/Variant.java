package fi.vm.yti.codelist.common.model;

import java.io.Serializable;
import java.util.Map;

public class Variant implements Serializable {
    private Map<String, String> prefLabel;
    private String uri;

    public Variant () {}

    public Variant (Map<String, String> prefLabel, String uri) {
        this.prefLabel = prefLabel;
        this.uri = uri;
    }

    public Map<String, String> getPrefLabel() {
        return prefLabel;
    }

    public void setPrefLabel(final Map<String, String> prefLabel) {
        this.prefLabel = prefLabel;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }
}
