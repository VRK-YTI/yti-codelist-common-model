package fi.vm.yti.cls.common.model;

public enum CodeSchemeType {

    CODELIST("CodeList", "Generic codelist."),
    CODELIST_CUSTOM("Custom CodeList", "Custom codelist.");

    private String name;

    private String description;

    CodeSchemeType(final String name,
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

