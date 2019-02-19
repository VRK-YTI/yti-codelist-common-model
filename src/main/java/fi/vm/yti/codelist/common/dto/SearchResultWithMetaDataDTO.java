package fi.vm.yti.codelist.common.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchResultWithMetaDataDTO {

    private Map<String, ArrayList<SearchHitDTO>> searchHitDTOMap = new HashMap<>();
    private Set<String> results = new HashSet<>();

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
}
