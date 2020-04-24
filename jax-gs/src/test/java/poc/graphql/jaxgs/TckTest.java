package poc.graphql.jaxgs;

import org.junit.Ignore;
import org.junit.Test;
import poc.graphql.jaxgs.core.Operation;
import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static poc.graphql.jaxgs.core.Argument.arg;
import static poc.graphql.jaxgs.core.ArgumentMap.args;
import static poc.graphql.jaxgs.core.Field.field;
import static poc.graphql.jaxgs.core.Field.fields;
import static poc.graphql.jaxgs.core.InputField.inputField;
import static poc.graphql.jaxgs.core.InputObject.inputObject;
import static poc.graphql.jaxgs.utils.AssertGraphql.assertSameRequests;

public class TckTest {
    @Test
    public void addHeroToTeam() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent("addHeroToTeam.graphql");

        GraphQLBuilder builder = new GraphQLBuilder(Operation.Type.MUTATION, "addHeroToTeam")
                .addRootField(
                        field("addHeroToTeam",
                                args(
                                        arg("hero", "Starlord"),
                                        arg("team", "Avengers")
                                ),
                                fields(
                                        field("name"),
                                        field("members",
                                                fields(
                                                        field("name")
                                                )
                                        )
                                )
                        ));

        String generatedRequest = builder.build();

        assertSameRequests(expectedRequest, generatedRequest);
    }

    @Test
    @Ignore
    // TODO
    public void addHeroToTeamWithVariables() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent("addHeroToTeamWithVariables.graphql");

        GraphQLBuilder builder = new GraphQLBuilder(Operation.Type.MUTATION, "addHeroToTeam")
                .addRootField(
                        field("addHeroToTeam",
                                args(
                                        arg("hero", "Starlord"),
                                        arg("team", "Avengers")
                                ),
                                fields(
                                        field("name"),
                                        field("members",
                                                fields(
                                                        field("name")
                                                )
                                        )
                                )
                        ));

        String generatedRequest = builder.build();

        assertSameRequests(expectedRequest, generatedRequest);
    }

    @Test
    public void addItemToHero() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent("addItemToHero.graphql");

        GraphQLBuilder builder = new GraphQLBuilder(Operation.Type.MUTATION, "provisionInfinityStone")
                .addRootField(
                        field("provisionHero",
                                args(
                                        arg("hero", "Starlord"),
                                        arg("item", inputObject(
                                                inputField("id", "12345"),
                                                inputField("name", "Power Infinity Stone"),
                                                inputField("height", 0.001),
                                                inputField("weight", 0.2),
                                                inputField("powerLevel", 99),
                                                inputField("supernatural", true)
                                        ))
                                ),
                                fields(
                                        field("name"),
                                        field("equipment",
                                                fields(
                                                        field("id"),
                                                        field("name"),
                                                        field("height"),
                                                        field("weight"),
                                                        field("powerLevel"),
                                                        field("supernatural")
                                                )
                                        )
                                )
                        ));

        String generatedRequest = builder.build();

        assertSameRequests(expectedRequest, generatedRequest);
    }

    @Test
    public void allAvengers() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent("allAvengers.graphql");

        GraphQLBuilder builder = new GraphQLBuilder(Operation.Type.QUERY, "allAvengers")
                .addRootField(
                        field("allHeroesInTeam",
                                args(
                                        arg("team", "Avengers")
                                ),
                                fields(
                                        field("name"),
                                        field("primaryLocation"),
                                        field("superPowers")
                                )
                        ));

        String generatedRequest = builder.build();

        assertSameRequests(expectedRequest, generatedRequest);
    }

    @Test
    @Ignore
    public void allAvengersWithVariables() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent("allAvengersWithVariables.graphql");

        GraphQLBuilder builder = new GraphQLBuilder(Operation.Type.QUERY, "allAvengers")
                .addRootField(
                        field("allHeroesInTeam",
                                args(
                                        arg("team", "Avengers")
                                ),
                                fields(
                                        field("name"),
                                        field("primaryLocation"),
                                        field("superPowers")
                                )
                        ));

        String generatedRequest = builder.build();

        assertSameRequests(expectedRequest, generatedRequest);
    }

    @Test
    public void allHeroes() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent("allHeroes.graphql");

        GraphQLBuilder builder = new GraphQLBuilder(Operation.Type.QUERY, "allHeroes")
                .addRootField(field("allHeroes",
                        fields(
                                field("name"),
                                field("primaryLocation"),
                                field("superPowers"),
                                field("realName")
                        )
                ));

        String generatedRequest = builder.build();

        assertSameRequests(expectedRequest, generatedRequest);
    }

    @Test
    public void basicScalarMutation() throws IOException, URISyntaxException, GraphQLBuilderException {
        String expectedRequest = getResourceFileContent("scalars.graphql");

        GraphQLBuilder builder = new GraphQLBuilder(Operation.Type.MUTATION, "scalarHolderMutation")
                .addRootField(
                        field("scalarHolder",
                                args(
                                        arg("scalarHolder", inputObject(
                                                inputField("shortPrimitive", 123),
                                                inputField("shortObject", 123),
                                                inputField("intPrimitive", 123456789),
                                                inputField("intObject", 123456789),
                                                inputField("longPrimitive", 123456789),
                                                inputField("longObject", 123456789),
                                                inputField("floatPrimitive", 123456.79),
                                                inputField("floatObject", 123456.79),
                                                inputField("doublePrimitive", 123456.789),
                                                inputField("doubleObject", 123456.789),
                                                inputField("bytePrimitive", 123),
                                                inputField("byteObject", 123),
                                                inputField("bigIntegerObject", 123456789),
                                                inputField("bigDecimalObject", 123456.789),
                                                inputField("booleanObject", false),
                                                inputField("booleanPrimitive", false),
                                                inputField("charObject", "c"),
                                                inputField("charPrimitive", "c"),
                                                inputField("stringObject", "123456789"),
                                                inputField("dateObject", "2019-10-23"),
                                                inputField("anotherDateObject", "2019-10-23"),
                                                inputField("timeObject", "11:46:34.263"),
                                                inputField("anotherTimeObject", "11:46:34.263"),
                                                inputField("dateTimeObject", "2019-10-23T11:46:34.263"),
                                                inputField("anotherDateTimeObject", "2019-10-23T11:46:34.263"),
                                                inputField("id", "123456789"),
                                                inputField("intPrimitiveId", 123456789),
                                                inputField("longPrimitiveId", 123456789)
                                        ))),
                                fields(
                                        field("shortPrimitive"),
                                        field("shortObject"),

                                        field("intPrimitive"),
                                        field("intObject"),

                                        field("longPrimitive"),
                                        field("longObject"),

                                        field("floatPrimitive"),
                                        field("floatObject"),

                                        field("doublePrimitive"),
                                        field(" doubleObject"),

                                        field("bytePrimitive"),
                                        field("byteObject"),

                                        field("bigIntegerObject"),

                                        field("bigDecimalObject"),

                                        field("booleanObject"),
                                        field("booleanPrimitive"),

                                        field("charObject"),
                                        field("charPrimitive"),

                                        field("stringObject"),

                                        field("dateObject"),
                                        field("anotherDateObject"),

                                        field("timeObject"),
                                        field("anotherTimeObject"),

                                        field("dateTimeObject"),
                                        field("anotherDateTimeObject"),

                                        field("id"),
                                        field("intPrimitiveId"),
                                        field("longPrimitiveId")
                                )
                        )
                );

        String generatedRequest = builder.build();
        assertSameRequests(expectedRequest, generatedRequest);
    }

    private String getResourceFileContent(String resourceName) throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        Path filePath = Paths.get(classLoader.getResource(resourceName).toURI());
        String content = new String(Files.readAllBytes(filePath));

        return content;
    }
}
