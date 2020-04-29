package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.LinkedHashMap;
import java.util.Map;

import static poc.graphql.jaxgs.utils.ValueFormatter.format;

public class ArgumentMap implements IBuildable {
    private LinkedHashMap<String, Object> map = new LinkedHashMap();

    @SafeVarargs
    public static ArgumentMap args(Argument... args) {
        return new ArgumentMap(args);
    }

    @SafeVarargs
    public ArgumentMap(Argument... args) {
        for (Argument argument : args) {
            map.put(argument.getName(), argument.getValue());
        }
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        int i = 0;
        for (Map.Entry<String, Object> entry : this.map.entrySet()) {
            builder.append(entry.getKey());
            builder.append(":");
            builder.append(format(entry.getValue()));
            if (i < this.map.size() - 1) {
                builder.append(", ");
            }
            i++;
        }
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }
}
