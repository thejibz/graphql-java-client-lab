package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.ArrayList;
import java.util.List;

public class Operation implements IBuildable {
    public enum Type {
        QUERY,
        MUTATION,
        SUBSCRIPTION
    }

    private Type type;
    private String name;
    private List<Field> fields;

    public Operation(Type type) {
        this.type = type;
        this.name = "";
        this.fields = new ArrayList<>();
    }

    public Operation(Type type, String name) {
        this.type = type;
        this.name = name;
        this.fields = new ArrayList<>();
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
            for (Field field : this.fields) {
                if (field.getFields().isEmpty()) {
                    builder.append(field.getName());
                } else {
                    field.build(builder);
                }
                builder.append(" ");
            }
        } else {
            throw new GraphQLBuilderException("An operation must have at least one root query.");
        }
        builder.append("}");
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
