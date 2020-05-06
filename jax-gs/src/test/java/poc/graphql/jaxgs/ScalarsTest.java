package poc.graphql.jaxgs;

import org.junit.Test;
import poc.graphql.jaxgs.core.Operation;
import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URISyntaxException;

import static poc.graphql.jaxgs.core.Argument.arg;
import static poc.graphql.jaxgs.core.Argument.args;
import static poc.graphql.jaxgs.core.Document.document;
import static poc.graphql.jaxgs.core.Field.field;
import static poc.graphql.jaxgs.core.Field.fields;
import static poc.graphql.jaxgs.core.InputObject.object;
import static poc.graphql.jaxgs.core.InputObjectField.prop;
import static poc.graphql.jaxgs.core.Operation.operation;
import static poc.graphql.jaxgs.utils.AssertGraphql.assertSameRequests;
import static poc.graphql.jaxgs.utils.Utils.getResourceFileContent;

public class ScalarsTest {

    @Test
    public void scalars() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent(getClass(), "scalars.graphql");

        Client client = ClientBuilder.newClient();
        client.withDocument(
                document(
                        operation(Operation.Type.MUTATION, "scalarHolderMutation",
                                field("scalarHolder",
                                        args(
                                                arg("scalarHolder", object(
                                                        prop("booleanPrimitive", false),
                                                        prop("booleanObject", Boolean.valueOf(true)),

                                                        prop("bytePrimitive", Byte.MIN_VALUE),
                                                        prop("byteObject", Byte.valueOf(Byte.MAX_VALUE)),

                                                        prop("shortPrimitive", Short.MIN_VALUE),
                                                        prop("shortObject", Short.valueOf(Short.MAX_VALUE)),

                                                        prop("intPrimitive", Integer.MIN_VALUE),
                                                        prop("intObject", Integer.valueOf(Integer.MAX_VALUE)),

                                                        prop("longPrimitive", Long.MIN_VALUE),
                                                        prop("longObject", Long.valueOf(Long.MAX_VALUE)),

                                                        prop("floatPrimitive", Float.MIN_VALUE),
                                                        prop("floatObject", Float.valueOf(Float.MAX_VALUE)),

                                                        prop("doublePrimitive", Double.MIN_VALUE),
                                                        prop("doubleObject", Double.valueOf(Double.MAX_VALUE)),

                                                        prop("bigInteger", BigInteger.TEN),
                                                        prop("bigDecimal", BigDecimal.TEN),

                                                        prop("charPrimitive", Character.MIN_VALUE),
                                                        prop("charObject", Character.valueOf(Character.MAX_VALUE)),

                                                        prop("stringObject", "Hello World !")
                                                ))),
                                        fields(
                                                field("booleanPrimitive"),
                                                field("booleanObject"),

                                                field("bytePrimitive"),
                                                field("byteObject"),

                                                field("shortPrimitive"),
                                                field("shortObject"),

                                                field("intPrimitive"),
                                                field("intObject"),

                                                field("longPrimitive"),
                                                field("longObject"),

                                                field("floatPrimitive"),
                                                field("floatObject"),

                                                field("doublePrimitive"),
                                                field("doubleObject"),

                                                field("bigInteger"),
                                                field("bigDecimal"),

                                                field("charPrimitive"),
                                                field("charObject"),

                                                field("stringObject")
                                        )
                                )
                        )));

        String generatedRequest = client.getDocument().toString();
        //System.out.println(generatedRequest);
        assertSameRequests(expectedRequest, generatedRequest);
    }
}
