package poc.graphql.jaxgs;

import org.junit.Ignore;
import org.junit.Test;
import poc.graphql.jaxgs.core.Operation;
import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.time.LocalDate;

import static java.util.Arrays.asList;
import static poc.graphql.jaxgs.core.Argument.arg;
import static poc.graphql.jaxgs.core.Argument.args;
import static poc.graphql.jaxgs.core.Field.field;
import static poc.graphql.jaxgs.core.Field.fields;
import static poc.graphql.jaxgs.core.InputField.inputField;
import static poc.graphql.jaxgs.core.InputObject.inputObject;
import static poc.graphql.jaxgs.utils.Sets.asSet;


/**
 * Unit test for simple App.
 */
public class SugarTest {

    @Test
    @Ignore
    public void shouldQueryBeGeneratedCorrectlyWithSugar() throws GraphQLBuilderException {
        String expectedQuery = """
                query {
                  allHeroesIn(city: "New York, NY") {
                    name
                    currentLocation
                    teamAffiliations {
                      name
                    }
                  }

                  allHeroes {
                    name
                  }
                }
                """;

        GraphQLBuilder builderWithSugar = new GraphQLBuilder(Operation.Type.QUERY)
                .addRootField(field("allHeroesIn",
                        asSet(
                                arg("city", "New York, NY")
                        ),
                        asList(
                                field("name"),
                                field("currentLocation"),
                                field("teamAffiliations",
                                        asList(
                                                field("name")
                                        )
                                )
                        )
                ))
                .addRootField(field("allHeroes", asList(field("name"))));


        String generatedQuery = builderWithSugar.build();

        System.out.println(generatedQuery);


//        String generatedQuery = getSuperHeroesFrom("Paris").asString();
//        assertThat(expectedQuery, equalToIgnoringWhiteSpace(generatedQuery));
    }

    @Test
    public void shouldMutationBeGeneratedCorrectly() throws GraphQLBuilderException {
        String expectedQuery = """
                mutation {
                  addHeroToTeam(hero: "Wolverine", team: "Avengers") {
                    name
                    rivalTeam {
                      name
                    }
                    members {
                      name
                    }
                  }
                }
                """;

        GraphQLBuilder builder = new GraphQLBuilder(Operation.Type.MUTATION)
                .addRootField(field("addHeroToTeam",
                        args(
                                arg("hero", "Wolverine"),
                                arg("team", "Avengers"),
                                arg("knownEnemies", asList("Wolverine", "Starlord", "Iron Man"))
                        ),
                        fields(
                                field("name"),
                                field("rivalTeam",
                                        fields(
                                                field("name"),
                                                field("members",
                                                        fields(
                                                                field("costumeColor")
                                                        )
                                                )
                                        )
                                )
                        )
                ))
                .addRootField(field("createNewHero",
                        args(
                                arg("hero", inputObject(
                                            inputField("costumeColor", "green"),
                                            inputField("dateOfLastCheckin", LocalDate.now()),
                                            inputField("equipment", null),
                                            inputField("idNumber", 456),
                                            inputField("knownEnemies", asList("Wolverine", "Starlord", "Iron Man")),
                                            inputField("name", "green lantern"),
                                            inputField("team", inputObject(
                                                    inputField("teamName", "Madagascar"),
                                                    inputField("teamSize", "XXL"),
                                                    inputField("teamLocation", inputObject(
                                                            inputField("lat", 123),
                                                            inputField("lon", 456)
                                                    ))
                                            ))
                                ))
                        ),
                        fields(
                                field("name"),
                                field("nameOfKnownEnemies")
                        )
                ));

        String generatedQuery = builder.build();

        System.out.println(generatedQuery);


//        String generatedQuery = getSuperHeroesFrom("Paris").asString();
//        assertThat(expectedQuery, equalToIgnoringWhiteSpace(generatedQuery));
    }
}