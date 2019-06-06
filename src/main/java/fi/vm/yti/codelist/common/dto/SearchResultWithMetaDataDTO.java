package fi.vm.yti.codelist.common.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SearchResultWithMetaDataDTO {

    private Map<String, ArrayList<SearchHitDTO>> searchHitDTOMap = new HashMap<>();
    private Set<String> results = new HashSet<>();
    private Map<String, Long> totalhitsCodesPerCodeSchemeMap = new HashMap<>();
    private Map<String, Long> totalhitsExtensionsPerCodeSchemeMap = new HashMap<>();

    public Map<String, ArrayList<SearchHitDTO>> getSearchHitDTOMap() {
        return searchHitDTOMap;
    }

    public void setSearchHitDTOMap(final Map<String, ArrayList<SearchHitDTO>> searchHitDTOMap) {
        this.searchHitDTOMap = searchHitDTOMap;
    }

    public Set<String> getResults() {
        return results;
    }

    public void setResults(final Set<String> results) {
        this.results = results;
    }

    public Map<String, Long> getTotalhitsCodesPerCodeSchemeMap() {
        return totalhitsCodesPerCodeSchemeMap;
    }

    public void setTotalhitsCodesPerCodeSchemeMap(final Map<String, Long> totalhitsCodesPerCodeSchemeMap) {
        this.totalhitsCodesPerCodeSchemeMap = totalhitsCodesPerCodeSchemeMap;
    }

    public Map<String, Long> getTotalhitsExtensionsPerCodeSchemeMap() {
        return totalhitsExtensionsPerCodeSchemeMap;
    }

    public void setTotalhitsExtensionsPerCodeSchemeMap(final Map<String, Long> totalhitsExtensionsPerCodeSchemeMap) {
        this.totalhitsExtensionsPerCodeSchemeMap = totalhitsExtensionsPerCodeSchemeMap;
    }
}
