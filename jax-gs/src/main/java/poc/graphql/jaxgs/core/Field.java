package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Field implements IBuildable {
    private String name;
    private ArgumentMap arguments;
    private List<Field> fields;


    @SafeVarargs
    public static <Field> List<Field> fields(Field... f) {
        return asList(f);
    }
    public static Field field(String name) {
        return new Field(name);
    }
    public static Field field(String name, ArgumentMap args) {
        return new Field(name, args);
    }
    public static Field field(String name, List<Field> fields) {
        return new Field(name, fields);
    }
    public static Field field(String name, ArgumentMap args, List<Field> fields) {
        return new Field(name, args, fields);
    }

    public Field(String name) {
        this.name = name;
        this.arguments = new ArgumentMap();
        this.fields = new ArrayList<>();
    }
    public Field(String name, ArgumentMap args) {
        this.name = name;
        this.arguments = args;
        this.fields = new ArrayList<>();
    }
    public Field(String name, List<Field> fields) {
        this.name = name;
        this.arguments = new ArgumentMap();
        this.fields = new ArrayList<>(fields);
    }
    public Field(String name, ArgumentMap args, List<Field> fields) {
        this.name = name;
        this.arguments = args;
        this.fields = new ArrayList<>(fields);
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        builder.append(this.name);

        if (!this.arguments.isEmpty()) {
            builder.append("(");
            this.arguments.build(builder);
            builder.append(")");
        }

        if (!this.fields.isEmpty()) {
            builder.append("{");
            _buildFields(builder);
            builder.append("}");
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
