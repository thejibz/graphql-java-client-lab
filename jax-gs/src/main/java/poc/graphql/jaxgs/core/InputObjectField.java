package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import static poc.graphql.jaxgs.utils.ValueFormatter.format;

public class InputObjectField implements IBuildable {
    private String name;
    private Object value;

    public static InputObjectField prop(String name, Object value) {
        return new InputObjectField(name, value);
    }

    public InputObjectField(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        builder.append(this.name);
        builder.append(":");
        builder.append(format(this.value));
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
