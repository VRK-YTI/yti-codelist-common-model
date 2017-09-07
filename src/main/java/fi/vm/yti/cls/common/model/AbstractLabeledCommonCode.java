package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

public class AbstractLabeledCommonCode extends AbstractCommonCode {

    private String prefLabelFi;
    private String prefLabelSe;
    private String prefLabelEn;
    private Map<String, String> prefLabels;

    public AbstractLabeledCommonCode() {
        prefLabels = new HashMap<>();
    }

    @JsonIgnore
    @Column(name = "preflabel_fi")
    public String getPrefLabelFi() {
        return prefLabelFi;
    }

    public void setPrefLabelFi(final String prefLabelFi) {

        addPrefLabel("fi", prefLabelFi);
        this.prefLabelFi = prefLabelFi;

    }

    @JsonIgnore
    @Column(name = "preflabel_se")
    public String getPrefLabelSe() {
        return prefLabelSe;
    }

    public void setPrefLabelSe(final String prefLabelSe) {
        addPrefLabel("se", prefLabelSe);
        this.prefLabelSe = prefLabelSe;
    }

    @JsonIgnore
    @Column(name = "preflabel_en")
    public String getPrefLabelEn() {
        return prefLabelEn;
    }

    public void setPrefLabelEn(final String prefLabelEn) {
        addPrefLabel("en", prefLabelEn);
        this.prefLabelEn = prefLabelEn;
    }

    @JsonProperty
    @Transient
    public Map<String, String> getPrefLabels() {
        return prefLabels;
    }

    public String getPrefLabel(final String language) {
        String prefLabel = prefLabels.get(language);
        if (prefLabel == null) {
            prefLabel = prefLabels.get("en");
        }
        return prefLabel;
    }

    private void addPrefLabel(final String language, final String name) {
        if (language != null && name != null && !name.isEmpty()) {
            prefLabels.put(language, name);
        } else if (language != null && name == null) {
            prefLabels.remove(language);
        }
    }

}
