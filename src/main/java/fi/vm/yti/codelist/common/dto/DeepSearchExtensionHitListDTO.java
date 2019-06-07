package fi.vm.yti.codelist.common.dto;

import java.util.List;

public class DeepSearchExtensionHitListDTO extends DeepSearchHitListDTO<ExtensionDTO> {

    public DeepSearchExtensionHitListDTO() {
        super(Type.EXTENSION);
    }

    public DeepSearchExtensionHitListDTO(long totalCount,
                                         List<ExtensionDTO> topHits) {
        super(Type.EXTENSION, totalCount, topHits);
    }
}
