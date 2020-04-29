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
import static poc.graphql.jaxgs.core.Field.selection;
import static poc.graphql.jaxgs.core.InputObjectField.prop;
import static poc.graphql.jaxgs.core.InputObject.object;
import static poc.graphql.jaxgs.utils.AssertGraphql.assertSameRequests;
import static poc.graphql.jaxgs.utils.Utils.getResourceFileContent;

public class NestedObjectsTest {

    @Test
    public void nestedObjects() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent(getClass(), "nestedObjects.graphql");

        InputObject baseObject_0 = object(
                prop("level", 0),
                prop("name", "level 0"),
                prop("levelLineage", new byte[]{}),
                prop("nestedObjectLineage", new InputObject[]{})
        );
        InputObject baseObject_1 = object(
                prop("level", 1),
                prop("name", "level 1"),
                prop("levelLineage", new byte[]{0}),
                prop("nestedObjectLineage", new InputObject[]{baseObject_0})
        );
        InputObject baseObject_2 = object(
                prop("level", 2),
                prop("name", "level 2"),
                prop("levelLineage", new byte[]{0, 1}),
                prop("nestedObjectLineage", new InputObject[]{baseObject_0, baseObject_1})
        );
        InputObject baseObject_3 = object(
                prop("level", 3),
                prop("name", "level 3"),
                prop("levelLineage", new byte[]{0, 1, 2}),
                prop("nestedObjectLineage", new InputObject[]{baseObject_0, baseObject_1, baseObject_2})
        );

        InputObject object_3 = (InputObject) baseObject_3.clone();
        object_3.add(prop("nestedObject", null));

        InputObject object_2 = (InputObject) baseObject_2.clone();
        object_2.add(prop("nestedObject", object_3));

        InputObject object_1 = (InputObject) baseObject_1.clone();
        object_1.add(prop("nestedObject", object_2));

        InputObject object_0 = (InputObject) baseObject_0.clone();
        object_0.add(prop("nestedObject", object_1));

        ClientBuilder builder = new ClientBuilder(Operation.Type.MUTATION, "nestedObjects")
                .addRootField(
                        field("nestedObjectHolder",
                                args(
                                        arg("nestedObjectHolder", object_0)
                                ),
                                selection(
                                        field("nestedObjectHolder")
                                )
                        )
                );

        String generatedRequest = builder.build();
        assertSameRequests(expectedRequest, generatedRequest);
    }
}
