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

public class ScalarsTest {

    @Test
    @Ignore
    public void scalars() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent(getClass(), "scalars.graphql");

        GraphQLBuilder builder = new GraphQLBuilder(Operation.Type.MUTATION, "scalarHolderMutation")
                .addRootField(
                        field("scalarHolder",
                                args(
                                        arg("scalarHolder", inputObject(
                                                inputField("booleanPrimitive", false),
                                                inputField("booleanObject", Boolean.valueOf(true)),

                                                inputField("bytePrimitive", Byte.MIN_VALUE),
                                                inputField("byteObject", Byte.valueOf(Byte.MAX_VALUE)),

                                                inputField("shortPrimitive", Short.MIN_VALUE),
                                                inputField("shortObject", Short.valueOf(Short.MAX_VALUE)),

                                                inputField("intPrimitive", Integer.MIN_VALUE),
                                                inputField("intObject", Integer.valueOf(Integer.MAX_VALUE)),

                                                inputField("longPrimitive", Long.MIN_VALUE),
                                                inputField("longObject", Long.valueOf(Long.MAX_VALUE)),

                                                inputField("floatPrimitive", Float.MIN_VALUE),
                                                inputField("floatObject", Float.valueOf(Float.MAX_VALUE)),

                                                inputField("doublePrimitive", Double.MIN_VALUE),
                                                inputField("doubleObject", Double.valueOf(Double.MAX_VALUE)),

                                                inputField("bigInteger", BigInteger.TEN),
                                                inputField("bigDecimal", BigDecimal.TEN),

                                                inputField("charPrimitive", Character.MIN_VALUE),
                                                inputField("charObject", Character.valueOf(Character.MAX_VALUE)),


                                                inputField("stringObject", "Hello World !")
                                        ))),
                                selections(
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
                );

        String generatedRequest = builder.build();

        assertSameRequests(expectedRequest, generatedRequest);
    }
}
