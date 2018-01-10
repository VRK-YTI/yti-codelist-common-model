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
    public static final String DATA_PROPERTYTYPES = "propertytypes";
    public static final String DATA_EXTERNALREFERENCES = "externalreferences";

    public static final String FILTER_NAME_CODEREGISTRY = "codeRegistry";
    public static final String FILTER_NAME_CODESCHEME = "codeScheme";
    public static final String FILTER_NAME_CODE = "code";
    public static final String FILTER_NAME_PROPERTYTYPE = "propertyType";
    public static final String FILTER_NAME_EXTERNALREFERENCE = "externalReference";
    public static final String FILTER_NAME_DATACLASSIFICATION = "dataClassification";
    public static final String FILTER_NAME_ORGANIZATION = "organization";

    public static final String FIELD_NAME_URI = "uri";
    public static final String FIELD_NAME_ID = "id";

    public static final String ELASTIC_INDEX_CODEREGISTRY = "coderegistry";
    public static final String ELASTIC_INDEX_CODESCHEME = "codescheme";
    public static final String ELASTIC_INDEX_CODE = "code";
    public static final String ELASTIC_INDEX_PROPERTYTYPE = "propertytype";
    public static final String ELASTIC_INDEX_EXTERNALREFERENCE = "externalreference";
    public static final String ELASTIC_TYPE_CODEREGISTRY = "coderegistry";
    public static final String ELASTIC_TYPE_CODESCHEME = "codescheme";
    public static final String ELASTIC_TYPE_CODE = "code";
    public static final String ELASTIC_TYPE_PROPERTYTYPE = "propertytype";
    public static final String ELASTIC_TYPE_EXTERNALREFERENCE = "externalreference";

    public static final String API_VERSION = "v1";
    public static final String API_CONTEXT_PATH_INTAKE = "/codelist-intake";
    public static final String API_CONTEXT_PATH_RESTAPI = "/codelist-api";

    public static final String API_BASE_PATH = "/api";
    public static final String API_PATH_VERSION_V1 = "/v1";
    public static final String API_PATH_AUTHENTICATED_USER = "/authenticated-user";
    public static final String API_PATH_CONFIGURATION = "/configuration";
    public static final String API_PATH_CODEREGISTRIES = "/coderegistries";
    public static final String API_PATH_CODESCHEMES = "/codeschemes";
    public static final String API_PATH_DATACLASSIFICATIONS = "/dataclassifications";
    public static final String API_PATH_EXTERNALREFERENCES = "/externalreferences";
    public static final String API_PATH_IMPERSONABLE_USERS = "/fakeableUsers";
    public static final String API_PATH_GROUPMANAGEMENT = "/groupmanagement";
    public static final String API_PATH_REQUEST = "/request";
    public static final String API_PATH_REQUESTS = "/requests";

    public static final String API_PATH_PROPERTYTYPES = "/propertytypes";
    public static final String API_PATH_ORGANIZATIONS = "/organizations";
    public static final String API_PATH_CODES = "/codes";
    public static final String API_PATH_PING = "/ping";
    public static final String API_PATH_VERSION = "/version";
    public static final String API_PATH_SWAGGER_JSON = "/swagger.json";

    public static final String DEFAULT_CODEREGISTRY_NAME_PREFIX = "testregistry";
    public static final String DEFAULT_CODESCHEME_NAME = "testscheme";

    public static final String EXCEL_SHEET_CODEREGISTRIES = "CodeRegistries";
    public static final String EXCEL_SHEET_CODESCHEMES = "CodeSchemes";
    public static final String EXCEL_SHEET_CODES = "Codes";
    public static final String EXCEL_SHEET_PROPERTYTYPES = "PropertyTypes";
    public static final String EXCEL_SHEET_EXTERNALREFERENCES = "ExternalReferences";

    public static final String CONTENT_HEADER_ID = "ID";
    public static final String CONTENT_HEADER_URL = "URL";
    public static final String CONTENT_HEADER_CODEVALUE = "CODEVALUE";
    public static final String CONTENT_HEADER_STATUS = "STATUS";
    public static final String CONTENT_HEADER_VERSION = "VERSION";
    public static final String CONTENT_HEADER_CLASSIFICATION = "CLASSIFICATION";
    public static final String CONTENT_HEADER_LOCALNAME = "LOCALNAME";
    public static final String CONTENT_HEADER_TYPE = "TYPE";
    public static final String CONTENT_HEADER_PROPERTYURI = "PROPERTYURI";
    public static final String CONTENT_HEADER_PROPERTYTYPE = "PROPERTYTYPE";
    public static final String CONTENT_HEADER_CONTEXT = "CONTEXT";
    public static final String CONTENT_HEADER_LEGALBASE = "LEGALBASE";
    public static final String CONTENT_HEADER_GOVERNANCEPOLICY = "GOVERNANCEPOLICY";
    public static final String CONTENT_HEADER_LICENSE = "LICENSE";
    public static final String CONTENT_HEADER_SOURCE = "SOURCE";
    public static final String CONTENT_HEADER_TITLE_PREFIX = "TITLE_";
    public static final String CONTENT_HEADER_PREFLABEL_PREFIX = "PREFLABEL_";
    public static final String CONTENT_HEADER_DEFINITION_PREFIX = "DEFINITION_";
    public static final String CONTENT_HEADER_DESCRIPTION_PREFIX = "DESCRIPTION_";
    public static final String CONTENT_HEADER_CHANGENOTE_PREFIX = "CHANGENOTE_";
    public static final String CONTENT_HEADER_SHORTNAME = "SHORTNAME";
    public static final String CONTENT_HEADER_HIERARCHYLEVEL = "HIERARCHYLEVEL";
    public static final String CONTENT_HEADER_STARTDATE = "STARTDATE";
    public static final String CONTENT_HEADER_ENDDATE = "ENDDATE";
    public static final String CONTENT_HEADER_PARENTCODESCHEMEID = "PARENTCODESCHEMEID";

    public static final String FORMAT_JSON = "json";
    public static final String FORMAT_CSV = "csv";
    public static final String FORMAT_EXCEL = "excel";
    public static final String FORMAT_EXCEL_XLS = "xls";
    public static final String FORMAT_EXCEL_XLSX = "xlsx";

    public static final String LANGUAGE_CODE_FI = "fi";
    public static final String LANGUAGE_CODE_SV = "sv";
    public static final String LANGUAGE_CODE_EN = "en";

    public static final String GROUPMANAGEMENT_API_CONTEXT_PATH = "/public-api";
    public static final String GROUPMANAGEMENT_API_USERS = "/users";
    public static final String GROUPMANAGEMENT_API_REQUEST = "/request";
    public static final String GROUPMANAGEMENT_API_REQUESTS = "/requests";
    public static final String GROUPMANAGEMENT_API_ORGANIZATIONS = "/organizations";
}
