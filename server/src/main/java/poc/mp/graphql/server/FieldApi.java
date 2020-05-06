package poc.mp.graphql.server;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import poc.mp.graphql.server.models.StringDoubleBoolHolder;

@GraphQLApi
public class FieldApi {
    @Query
    public String noArgNoSubField() {
        return "noArgNoSubField";
    }

    @Query
    public int withArgNoSubField(int anInt) {
        return anInt;
    }

    @Query
    public StringDoubleBoolHolder noArgWithSubField() {
        return new StringDoubleBoolHolder("hello", 42.42d, true);
    }

    @Query
    public StringDoubleBoolHolder withArgWithSubField(String aString, double aDouble, boolean aBool) {
        return new StringDoubleBoolHolder(aString, aDouble, aBool);
    }
}
