package poc.mp.graphql.server;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import poc.mp.graphql.server.models.ArrayHolder;
import poc.mp.graphql.server.models.IntArrayHolder;
import poc.mp.graphql.server.models.ScalarHolder;

/**
 *
 */
@GraphQLApi
public class TckGraphQLApi {

    @Query
    public String helloWorld() {
        return "helloWorld";
    }

    @Mutation
    public ScalarHolder scalarHolder(ScalarHolder scalarHolder) {
        return scalarHolder;
    }

    @Query
    public ArrayHolder arrayHolder(ArrayHolder arrayHolder) {
        return arrayHolder;
    }

    @Query
    public IntArrayHolder intArrayHolder(IntArrayHolder intArrayHolder) {
        return intArrayHolder;
    }
}
