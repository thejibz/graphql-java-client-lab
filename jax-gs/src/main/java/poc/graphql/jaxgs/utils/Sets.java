package poc.graphql.jaxgs.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Sets {
    private Sets() {};

    @SafeVarargs
    public static <T> Set<T> asSet(T... a) {
        return new HashSet<T>(Arrays.asList(a));
    }
}
