package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.AbstractMap;

import static poc.graphql.jaxgs.utils.ValueFormatter.format;

public class Argument extends AbstractMap.SimpleEntry<String, Object> implements IBuildable {

    public static Argument arg(String key, Object value) {
        return new Argument(key, value);
    }

    public Argument(String key, Object value) {
        super(key, value);
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        builder.append(this.getKey());
        builder.append(":");
        builder.append(format(this.getValue()));
    }
}
