package poc.graphql.jaxgs;

import org.junit.Test;
import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.io.IOException;
import java.net.URISyntaxException;

import static poc.graphql.jaxgs.core.Argument.arg;
import static poc.graphql.jaxgs.core.Argument.args;
import static poc.graphql.jaxgs.core.Document.document;
import static poc.graphql.jaxgs.core.Field.field;
import static poc.graphql.jaxgs.core.Field.fields;
import static poc.graphql.jaxgs.core.Operation.operation;
import static poc.graphql.jaxgs.utils.AssertGraphql.assertSameRequests;
import static poc.graphql.jaxgs.utils.Utils.getResourceFileContent;

public class FieldTest {

    @Test
    public void fieldTest() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent(getClass(), "field.graphql");

        Client client = ClientBuilder.newClient();
        client.withDocument(
                document(
                        operation(
                                field("noArgNoSubField"),
                                field("noArgWithSubField",
                                        field("bool"),
                                        field("string"),
                                        field("double")
                                ),
                                field("withArgNoSubField", arg("anInt", 42)),
                                field("withArgWithSubField", args(
                                        arg("aString", "world"),
                                        arg("aDouble", 78.12d),
                                        arg("aBool", false)), fields(
                                        field("bool"),
                                        field("string"),
                                        field("double")
                                ))
                        )));


        String generatedRequest = client.getDocument().toString();
        //System.out.println(generatedRequest);
        assertSameRequests(expectedRequest, generatedRequest);
    }
}
