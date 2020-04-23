package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArgumentMap extends LinkedHashMap<String, Object> implements IBuildable {

    @SafeVarargs
    public static ArgumentMap args(Argument... args) {
        ArgumentMap argumentMap = new ArgumentMap();
        for(Argument argument : args) {
            argumentMap.put(argument.getKey(), argument.getValue());
        }

        return argumentMap;
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        int i = 0;
        for (Map.Entry<String, Object> entry : Collections.unmodifiableSet(this.entrySet())) {
            Argument argument = new Argument(entry.getKey(), entry.getValue());
            argument.build(builder);
            if (i < this.size() - 1) {
                builder.append(", ");
            }
            i++;
        }
    }
}
