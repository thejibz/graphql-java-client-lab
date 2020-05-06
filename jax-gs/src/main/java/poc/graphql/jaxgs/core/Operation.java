package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.List;

import static java.util.Arrays.asList;

public class Operation implements IBuildable {
    private Type type;
    private String name;
    private List<Field> fields;

    @SafeVarargs
    public static List<Operation> operations(Operation... operations) {
        return asList(operations);
    }
    public static Operation operation(List<Field> fields) { return new Operation(fields); }
    public static Operation operation(Type type, List<Field> fields) {
        return new Operation(type, fields);
    }
    public static Operation operation(Type type, String name, List<Field> fields) {
        return new Operation(type, name, fields);
    }

    public Operation(List<Field> fields) {
        this.type = Type.QUERY;
        this.name = "";
        this.fields = fields;
    }

    public Operation(Type type, List<Field> fields) {
        this.type = type;
        this.name = "";
        this.fields = fields;
    }

    public Operation(Type type, String name, List<Field> fields) {
        this.type = type;
        this.name = name;
        this.fields = fields;
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        switch (type) {
            case QUERY:
                builder.append("query ");
                break;
            case MUTATION:
                builder.append("mutation ");
                break;
            case SUBSCRIPTION:
                builder.append("subscription ");
                break;
            default:
                throw new GraphQLBuilderException("Operation type must be one of QUERY, MUTATION or SUBSCRIPTION");
        }

        builder.append(this.name);
        builder.append("{");
        if (!this.fields.isEmpty()) {
            Field[] rootFields = this.fields.toArray(new Field[0]);
            for (int i = 0; i < rootFields.length; i++) {
                Field rootField = rootFields[i];
                rootField.build(builder);
                if (i < rootFields.length - 1) {
                    builder.append(" ");
                }
            }
        } else {
            throw new GraphQLBuilderException("An operation must have at least one root field.");
        }
        builder.append("}");
    }

    public enum Type {
        QUERY,
        MUTATION,
        SUBSCRIPTION
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
