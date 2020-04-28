package poc.graphql.jaxgs;

import poc.graphql.jaxgs.core.Field;
import poc.graphql.jaxgs.core.Operation;
import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

public class GraphQLBuilder {
    private Operation operation;

    public GraphQLBuilder(Operation.Type type) {
        this.operation = new Operation(type);
    }

    public GraphQLBuilder(Operation.Type type, String name) {
        this.operation = new Operation(type, name);
    }

    public GraphQLBuilder addRootField(Field rootField) {
        this.operation.getFields().add(rootField);

        return this;
    }

    public String build() throws GraphQLBuilderException {
        StringBuilder queryBuilder = new StringBuilder();

        this.operation.build(queryBuilder);

        return queryBuilder.toString();
    }
}
