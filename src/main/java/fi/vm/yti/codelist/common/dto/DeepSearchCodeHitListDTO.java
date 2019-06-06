package fi.vm.yti.codelist.common.dto;

import java.util.List;

public class DeepSearchCodeHitListDTO extends DeepSearchHitListDTO<CodeDTO> {

    public DeepSearchCodeHitListDTO() {
        super(Type.CODE);
    }

    public DeepSearchCodeHitListDTO(long totalCount,
                                    List<CodeDTO> topHits) {
        super(Type.CODE, totalCount, topHits);
    }
}
