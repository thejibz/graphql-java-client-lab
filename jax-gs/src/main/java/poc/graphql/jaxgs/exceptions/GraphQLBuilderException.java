package poc.graphql.jaxgs.exceptions;

public class GraphQLBuilderException extends Exception {
    public GraphQLBuilderException(String builder_error) {
        super(builder_error);
    }
}
