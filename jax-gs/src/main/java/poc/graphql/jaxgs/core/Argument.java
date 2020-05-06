package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.List;

import static java.util.Arrays.asList;
import static poc.graphql.jaxgs.utils.ValueFormatter.format;

public class Argument implements IBuildable {
    private String name;
    private Object value;

    @SafeVarargs
    public static List<Argument> args(Argument... args) {
        return asList(args);
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
        builder.append(this.name);
        builder.append(":");
        builder.append(format(this.value));
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
