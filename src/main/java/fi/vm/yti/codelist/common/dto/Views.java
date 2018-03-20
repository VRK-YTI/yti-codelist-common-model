package fi.vm.yti.codelist.common.dto;

public class Views {

    private Views() {
    }

    public static class Normal{};

    public static class Extended extends Normal{};

    public static class ExtendedExternalReference extends Normal{};

    public static class ExtendedCode extends Normal{};

    public static class ExtendedCodeScheme extends Normal{};

    public static class ExtendedOrganization extends Normal{};
}
