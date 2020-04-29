package poc.graphql.jaxgs;

import poc.graphql.jaxgs.core.Document;
import poc.graphql.jaxgs.core.Field;
import poc.graphql.jaxgs.core.Operation;
import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

public class ClientBuilder {
    private Operation operation;
    private Document document;

    public static Client newClient() {
        return new Client();
    }

    public ClientBuilder(Operation.Type type) {
        this.operation = new Operation(type);
    }

    public ClientBuilder(Operation.Type type, String name) {
        this.operation = new Operation(type, name);
    }

    public ClientBuilder(Document doc) {

    }

    public ClientBuilder addRootField(Field rootField) {
        this.operation.getFields().add(rootField);

        return this;
    }

    public String build() throws GraphQLBuilderException {
        StringBuilder queryBuilder = new StringBuilder();

        this.operation.build(queryBuilder);

        return queryBuilder.toString();
    }
}
