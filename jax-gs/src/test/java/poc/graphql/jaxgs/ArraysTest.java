package poc.graphql.jaxgs;

import org.junit.Ignore;
import org.junit.Test;
import poc.graphql.jaxgs.core.Operation;
import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URISyntaxException;

import static poc.graphql.jaxgs.core.Argument.arg;
import static poc.graphql.jaxgs.core.ArgumentMap.args;
import static poc.graphql.jaxgs.core.Field.field;
import static poc.graphql.jaxgs.core.Field.selections;
import static poc.graphql.jaxgs.core.InputField.inputField;
import static poc.graphql.jaxgs.core.InputObject.inputObject;
import static poc.graphql.jaxgs.utils.AssertGraphql.assertSameRequests;
import static poc.graphql.jaxgs.utils.Utils.getResourceFileContent;

public class ArraysTest {

    @Test
    @Ignore
    public void arrays() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent(getClass(), "arrays.graphql");

        GraphQLBuilder builder = new GraphQLBuilder(Operation.Type.QUERY, "arrayHolderQuery")
                .addRootField(
                        field("arrayHolder",
                                args(
                                        arg("arrayHolder", inputObject(
                                                inputField("boolPrimitiveArray", new boolean[]{true, false, true}),
                                                inputField("boolObjectArray", new Boolean[]{true, false, true}),

                                                inputField("bytePrimitiveArray", new byte[]{0, 2, 3}),
                                                inputField("byteObjectArray", new Byte[]{0, 2, 3}),

                                                inputField("shortPrimitiveArray", new short[]{78, 789, 645}),
                                                inputField("shortObjectArray", new Short[]{78, 789, 645}),

                                                inputField("intPrimitiveArray", new int[]{78, 65, 12354}),
                                                inputField("intObjectArray", new Integer[]{78, 65, 12354}),

                                                inputField("longPrimitiveArray", new long[]{789L, 947894L, 1874448L}),
                                                inputField("longObjectArray", new Long[]{789L, 947894L, 1874448L}),

                                                inputField("floatPrimitiveArray", new float[]{1567.654f, 8765f, 123789456.1851f}),
                                                inputField("floatObjectArray", new Float[]{1567.654f, 8765f, 123789456.1851f}),

                                                inputField("doublePrimitiveArray", new double[]{789.3242d, 1815d, 98765421.654897d}),
                                                inputField("doubleObjectArray", new Double[]{789.3242d, 1815d, 98765421.654897d}),

                                                inputField("bigIntegerArray", new BigInteger[]{BigInteger.ZERO, BigInteger.ONE, BigInteger.TEN}),
                                                inputField("bigDecimalArray", new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN}),

                                                inputField("charPrimitiveArray", new char[]{'f', 'o', 'o'}),
                                                inputField("charObjectArray", new Character[]{'f', 'o', 'o'}),

                                                inputField("stringArray", new String[]{"foo", "bar", "baz"})
                                        ))),
                                selections(
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
                );

        String generatedRequest = builder.build();
        assertSameRequests(expectedRequest, generatedRequest);
    }
}
