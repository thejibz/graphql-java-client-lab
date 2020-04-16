package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.AbstractMap;

import static poc.graphql.jaxgs.utils.ValueFormatter.format;

public class InputField extends AbstractMap.SimpleEntry<String, Object> implements IBuildable {

    public static InputField inputField(String key, Object value) {
        return new InputField(key, value);
    }

    public InputField(String key, Object value) {
        super(key, value);
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        builder.append(this.getKey());
        builder.append(":");
        if (this.getValue() instanceof InputObject) {
            ((InputObject) this.getValue()).build(builder);
        } else {
            builder.append(format(this.getValue()));
        }
    }
}
