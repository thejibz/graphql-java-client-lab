package poc.graphql.jaxgs;

import org.junit.Test;
import poc.graphql.jaxgs.core.InputObject;
import poc.graphql.jaxgs.core.Operation;
import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.io.IOException;
import java.net.URISyntaxException;

import static poc.graphql.jaxgs.core.Argument.arg;
import static poc.graphql.jaxgs.core.ArgumentMap.args;
import static poc.graphql.jaxgs.core.Field.field;
import static poc.graphql.jaxgs.core.Field.selections;
import static poc.graphql.jaxgs.core.InputField.inputField;
import static poc.graphql.jaxgs.core.InputObject.inputObject;
import static poc.graphql.jaxgs.utils.AssertGraphql.assertSameRequests;
import static poc.graphql.jaxgs.utils.Utils.getResourceFileContent;

public class NestedObjectsTest {

    @Test
    public void nestedObjects() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent(getClass(), "nestedObjects.graphql");

        InputObject baseObject_0 = inputObject(
                inputField("level", 0),
                inputField("name", "level 0"),
                inputField("levelLineage", new byte[]{}),
                inputField("nestedObjectLineage", new InputObject[]{})
        );
        InputObject baseObject_1 = inputObject(
                inputField("level", 1),
                inputField("name", "level 1"),
                inputField("levelLineage", new byte[]{0}),
                inputField("nestedObjectLineage", new InputObject[]{baseObject_0})
        );
        InputObject baseObject_2 = inputObject(
                inputField("level", 2),
                inputField("name", "level 2"),
                inputField("levelLineage", new byte[]{0, 1}),
                inputField("nestedObjectLineage", new InputObject[]{baseObject_0, baseObject_1})
        );
        InputObject baseObject_3 = inputObject(
                inputField("level", 3),
                inputField("name", "level 3"),
                inputField("levelLineage", new byte[]{0, 1, 2}),
                inputField("nestedObjectLineage", new InputObject[]{baseObject_0,baseObject_1, baseObject_2})
        );

        InputObject object_3 = (InputObject) baseObject_3.clone();
        object_3.put("nestedObject", null);

        InputObject object_2 = (InputObject) baseObject_2.clone();
        object_2.put("nestedObject", object_3);

        InputObject object_1 = (InputObject) baseObject_1.clone();
        object_1.put("nestedObject", object_2);

        InputObject object_0 = (InputObject) baseObject_0.clone();
        object_0.put("nestedObject", object_1);

        GraphQLBuilder builder = new GraphQLBuilder(Operation.Type.MUTATION, "nestedObjects")
                .addRootField(
                        field("nestedObjectHolder",
                                args(
                                        arg("nestedObjectHolder", object_0)
                                ),
                                selections(
                                        field("nestedObjectHolder")
                                )
                        )
                );

        String generatedRequest = builder.build();

        assertSameRequests(expectedRequest, generatedRequest);
    }
}
