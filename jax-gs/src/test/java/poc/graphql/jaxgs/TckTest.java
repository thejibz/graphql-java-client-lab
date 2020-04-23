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
                .addRootField(
                        field("allHeroes",
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

    private String getResourceFileContent(String resourceName) throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        Path filePath = Paths.get(classLoader.getResource(resourceName).toURI());
        String content = Files.readString(filePath);

        return content;
    }
}
