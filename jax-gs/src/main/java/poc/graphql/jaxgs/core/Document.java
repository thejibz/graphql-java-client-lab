package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.List;

public class Document implements IBuildable {
    private List<Operation> operations;
    private Fragment fragments;

    public static Document document(List<Operation> operations) {
        return new Document(operations);
    }
    public static Document document(List<Operation> operations, Fragment fragments) {
        return new Document(operations, fragments);
    }

    public Document(List<Operation> operations) {
        this.operations = operations;
        this.fragments = new Fragment();
    }
    public Document(List<Operation> operations, Fragment fragments) {
        this.operations = operations;
        this.fragments = fragments;
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        for(Operation operation : this.operations) {
            operation.build(builder);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        try {
            this.build(builder);
        } catch (GraphQLBuilderException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
