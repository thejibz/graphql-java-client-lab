package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.List;

import static java.util.Arrays.asList;

public class Field implements IBuildable {
    private String name;
    private List<Argument> arguments;
    private List<Field> fields;

    @SafeVarargs
    public static List<Field> fields(Field... fields) {
        return asList(fields);
    }
    public static Field field(String name) {
        return new Field(name);
    }
    @SafeVarargs
    public static Field field(String name, Argument... args) {
        return new Field(name, args);
    }
    @SafeVarargs
    public static Field field(String name, Field... fields) {
        return new Field(name, fields);
    }
    public static Field field(String name, List<Argument> args, List<Field> fields) {
        return new Field(name, args, fields);
    }

    public Field(String name) {
        this.name = name;
        this.arguments = asList(new Argument[0]);
        this.fields = asList(new Field[0]);
    }
    @SafeVarargs
    public Field(String name, Argument... args) {
        this.name = name;
        this.arguments = asList(args);
        this.fields = asList(new Field[0]);
    }
    @SafeVarargs
    public Field(String name, Field... fields) {
        this.name = name;
        this.arguments = asList(new Argument[0]);
        this.fields = asList(fields);
    }
    public Field(String name, List<Argument> args, List<Field> fields) {
        this.name = name;
        this.arguments = args;
        this.fields = fields;
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        builder.append(this.name);

        // Arguments to build ?
        if (!this.arguments.isEmpty()) {
            builder.append("(");
            _buildArgs(builder);
            builder.append(")");
        }

        // Sub-fields to build ?
        if (!this.fields.isEmpty()) {
            builder.append("{");
            _buildFields(builder);
            builder.append("}");
        }
    }

    private void _buildArgs(StringBuilder builder) throws GraphQLBuilderException {
        Argument[] arguments = this.arguments.toArray(new Argument[0]);
        for (int i = 0; i < arguments.length; i++) {
            Argument argument = arguments[i];
            argument.build(builder);
            if (i < arguments.length - 1) {
                builder.append(",");
            }
        }
    }

    private void _buildFields(StringBuilder builder) throws GraphQLBuilderException {
        Field[] fields = this.fields.toArray(new Field[0]);
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.build(builder);
            if (i < fields.length - 1) {
                builder.append(" ");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
