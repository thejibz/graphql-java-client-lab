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

public class ArraysTest {

    @Test
    public void arrays() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent(getClass(), "arrays.graphql");

        Client client = ClientBuilder.newClient();
        client.withDocument(
                document(
                        operation(Operation.Type.QUERY, "arrayHolderQuery",
                                field("arrayHolder",
                                        args(
                                                arg("arrayHolder", object(
                                                        prop("boolPrimitiveArray", new boolean[]{true, false, true}),
                                                        prop("boolObjectArray", new Boolean[]{true, false, true}),

                                                        prop("bytePrimitiveArray", new byte[]{0, 2, 3}),
                                                        prop("byteObjectArray", new Byte[]{0, 2, 3}),

                                                        prop("shortPrimitiveArray", new short[]{78, 789, 645}),
                                                        prop("shortObjectArray", new Short[]{78, 789, 645}),

                                                        prop("intPrimitiveArray", new int[]{78, 65, 12354}),
                                                        prop("intObjectArray", new Integer[]{78, 65, 12354}),

                                                        prop("longPrimitiveArray", new long[]{789L, 947894L, 1874448L}),
                                                        prop("longObjectArray", new Long[]{789L, 947894L, 1874448L}),

                                                        prop("floatPrimitiveArray", new float[]{1567.654f, 8765f, 123789456.1851f}),
                                                        prop("floatObjectArray", new Float[]{1567.654f, 8765f, 123789456.1851f}),

                                                        prop("doublePrimitiveArray", new double[]{789.3242d, 1815d, 98765421.654897d}),
                                                        prop("doubleObjectArray", new Double[]{789.3242d, 1815d, 98765421.654897d}),

                                                        prop("bigIntegerArray", new BigInteger[]{BigInteger.ZERO, BigInteger.ONE, BigInteger.TEN}),
                                                        prop("bigDecimalArray", new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN}),

                                                        prop("charPrimitiveArray", new char[]{'f', 'o', 'o'}),
                                                        prop("charObjectArray", new Character[]{'f', 'o', 'o'}),

                                                        prop("stringArray", new String[]{"foo", "bar", "baz"})
                                                ))),
                                        fields(
                                                field("boolPrimitiveArray"),
                                                field("boolObjectArray"),

                                                field("bytePrimitiveArray"),
                                                field("byteObjectArray"),

                                                field("shortPrimitiveArray"),
                                                field("shortObjectArray"),

                                                field("intPrimitiveArray"),
                                                field("intObjectArray"),

                                                field("longPrimitiveArray"),
                                                field("longObjectArray"),

                                                field("floatPrimitiveArray"),
                                                field("floatObjectArray"),

                                                field("doublePrimitiveArray"),
                                                field("doubleObjectArray"),

                                                field("bigIntegerArray"),
                                                field("bigDecimalArray"),

                                                field("charPrimitiveArray"),
                                                field("charObjectArray"),

                                                field("stringArray")
                                        )
                                )
                        )));


        String generatedRequest = client.getDocument().toString();
        //System.out.println(generatedRequest);
        assertSameRequests(expectedRequest, generatedRequest);
    }
}
