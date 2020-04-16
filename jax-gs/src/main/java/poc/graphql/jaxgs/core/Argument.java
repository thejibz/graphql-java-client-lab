package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.Set;

import static poc.graphql.jaxgs.utils.Sets.asSet;
import static poc.graphql.jaxgs.utils.ValueFormatter.format;

public class Argument implements IBuildable {
    private String name;
    private Object value;

    @SafeVarargs
    public static <Argument> Set<Argument> args(Argument... a) {
        return asSet(a);
    }

    public static Argument arg(String name, Object value) {
        return new Argument(name, value);
    }

    public Argument(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        builder.append(name);
        builder.append(":");
        if (value instanceof InputObject) {
            var inputObject = (InputObject) value;
            inputObject.build(builder);
        } else {
            // Arrays are automatically well formatted. Ne need for  a special case.
            builder.append(format(value));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
