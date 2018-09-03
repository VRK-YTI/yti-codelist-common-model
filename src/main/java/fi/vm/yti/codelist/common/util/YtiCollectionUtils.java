package fi.vm.yti.codelist.common.util;

import java.util.Collection;
import java.util.function.Predicate;

public class YtiCollectionUtils {

    private YtiCollectionUtils() {}

    private static <T> boolean contains(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream().anyMatch(predicate);
    }

    public static <T extends Identifiable> boolean containsItemWithSameId(Collection<T> collection, T itemToCheck) {
        return contains(collection, item -> item.getId().equals(itemToCheck.getId()));
    }

}
