package fi.vm.yti.codelist.common.constants;

public class ApiConstants {

    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_PATCH = "PATCH";

    public static final String SOURCE_INTERNAL = "internal";
    public static final String DATA_CODEREGISTRIES = "coderegistries";
    public static final String DATA_CODESCHEMES = "codeschemes";
    public static final String DATA_CODES = "codes";

    public static final String ELASTIC_INDEX_CODEREGISTRY = "coderegistry";
    public static final String ELASTIC_INDEX_CODESCHEME = "codescheme";
    public static final String ELASTIC_INDEX_CODE = "code";
    public static final String ELASTIC_TYPE_CODEREGISTRY = "coderegistry";
    public static final String ELASTIC_TYPE_CODESCHEME = "codescheme";
    public static final String ELASTIC_TYPE_CODE = "code";

    public static final String API_VERSION = "v1";
    public static final String API_CONTEXT_PATH_INTAKE = "/codelist-intake";
    public static final String API_CONTEXT_PATH_RESTAPI = "/codelist-api";

    public static final String API_BASE_PATH = "/api";
    public static final String API_PATH_VERSION_V1 = "/v1";
    public static final String API_PATH_CODEREGISTRIES = "/coderegistries";
    public static final String API_PATH_CODESCHEMES = "/codeschemes";
    public static final String API_PATH_CODES = "/codes";
    public static final String API_PATH_PING = "/ping";
    public static final String API_PATH_VERSION = "/version";
    public static final String API_PATH_SWAGGER_JSON = "/swagger.json";

    public static final String DEFAULT_CODESCHEME_FILENAME = "v1_codeschemes.csv";
    public static final String DEFAULT_CODEREGISTRY_FILENAME = "v1_coderegistries.csv";
    public static final String DEFAULT_CODE_FILENAME = "v1_codes.csv";
    public static final String DEFAULT_CODEREGISTRY_NAME_PREFIX = "testregistry";
    public static final String DEFAULT_CODESCHEME_NAME = "testscheme";
    public static final String FILTER_NAME_CODEREGISTRY = "codeRegistry";

    public static final String CSV_HEADER_ID = "ID";
    public static final String CSV_HEADER_CODEVALUE = "CODEVALUE";
    public static final String CSV_HEADER_STATUS = "STATUS";
    public static final String CSV_HEADER_VERSION = "VERSION";
    public static final String CSV_HEADER_PREFLABEL_FI = "PREFLABEL_FI";
    public static final String CSV_HEADER_PREFLABEL_SE = "PREFLABEL_SE";
    public static final String CSV_HEADER_PREFLABEL_EN = "PREFLABEL_EN";
    public static final String CSV_HEADER_DEFINITION_FI = "DEFINITION_FI";
    public static final String CSV_HEADER_DEFINITION_SE = "DEFINITION_SE";
    public static final String CSV_HEADER_DEFINITION_EN = "DEFINITION_EN";
    public static final String CSV_HEADER_DESCRIPTION_FI = "DESCRIPTION_FI";
    public static final String CSV_HEADER_DESCRIPTION_SE = "DESCRIPTION_SE";
    public static final String CSV_HEADER_DESCRIPTION_EN = "DESCRIPTION_EN";
    public static final String CSV_HEADER_CHANGENOTE_FI = "CHANGENOTE_FI";
    public static final String CSV_HEADER_CHANGENOTE_SE = "CHANGENOTE_SE";
    public static final String CSV_HEADER_CHANGENOTE_EN = "CHANGENOTE_EN";
    public static final String CSV_HEADER_SHORTNAME = "SHORTNAME";
    public static final String CSV_HEADER_STARTDATE = "STARTDATE";
    public static final String CSV_HEADER_ENDDATE = "ENDDATE";

    public static final String FORMAT_JSON = "json";
    public static final String FORMAT_CSV = "csv";
    public static final String LANGUAGE_CODE_FI = "fi";
    public static final String LANGUAGE_CODE_SE = "se";
    public static final String LANGUAGE_CODE_EN = "en";
}
