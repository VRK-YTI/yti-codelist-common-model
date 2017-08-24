package fi.vm.yti.cls.common.model;


public enum RegisterType {

    CODELIST("CodeList", "Generic codelist."),
    CODELIST_CUSTOM("Custom CodeList", "Custom codelist.");

    private String m_name;

    private String m_description;


    RegisterType(final String name,
                 final String description) {

        m_name = name;

        m_description = description;

    }


    public String getDescription() {
        return m_description;
    }


    public String getName() {
        return m_name;
    }

}

