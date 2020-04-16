package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

public interface IBuildable {
    void build(StringBuilder builder) throws GraphQLBuilderException;
}
