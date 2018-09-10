package fi.vm.yti.codelist.common.util;

import java.util.UUID;

@FunctionalInterface
public interface Identifiable {
    UUID getId();
}
