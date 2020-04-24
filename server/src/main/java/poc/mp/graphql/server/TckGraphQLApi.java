package poc.mp.graphql.server;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

/**
 *
 */
@GraphQLApi
public class TckGraphQLApi {

    @Query
    public String myQuery() {
        return "query";
    }

    @Mutation
    public ScalarHolder scalarHolder(ScalarHolder scalarHolder) {
        return scalarHolder;
    }
}
