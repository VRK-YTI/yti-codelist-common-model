package fi.vm.yti.cls.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;


public class AbstractLabeledCommonCode extends AbstractCommonCode {

    private String m_prefLabelFi;

    private String m_prefLabelSe;

    private String m_prefLabelEn;

    private Map<String, String> m_prefLabels;


    public AbstractLabeledCommonCode() {

        m_prefLabels = new HashMap<>();

    }


    @JsonIgnore
    @Column(name = "preflabel_fi")
    public String getPrefLabelFi() {
        return m_prefLabelFi;
    }

    public void setPrefLabelFi(final String prefLabelFi) {

        addPrefLabel("fi", prefLabelFi);
        m_prefLabelFi = prefLabelFi;

    }


    @JsonIgnore
    @Column(name = "preflabel_se")
    public String getPrefLabelSe() {
        return m_prefLabelSe;
    }

    public void setPrefLabelSe(final String prefLabelSe) {

        addPrefLabel("se", prefLabelSe);
        m_prefLabelSe = prefLabelSe;

    }


    @JsonIgnore
    @Column(name = "preflabel_en")
    public String getPrefLabelEn() {
        return m_prefLabelEn;
    }

    public void setPrefLabelEn(final String prefLabelEn) {

        addPrefLabel("en", prefLabelEn);
        m_prefLabelEn = prefLabelEn;

    }

    @JsonProperty
    @Transient
    public Map<String, String> getPrefLabels() {

        return m_prefLabels;

    }

    public String getPrefLabel(final String language) {

        String prefLabel = m_prefLabels.get(language);

        if (prefLabel == null) {
            prefLabel = m_prefLabels.get("en");
        }

        return prefLabel;
    }


    private void addPrefLabel(final String language, final String name) {

        if (language != null && name != null && !name.isEmpty()) {
            m_prefLabels.put(language, name);

        } else if (language != null && name == null) {
            m_prefLabels.remove(language);
        }

    }


}
