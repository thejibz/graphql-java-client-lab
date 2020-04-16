package poc.graphql.jaxgs;

import org.junit.Ignore;
import org.junit.Test;
import poc.graphql.jaxgs.core.Argument;
import poc.graphql.jaxgs.core.Field;
import poc.graphql.jaxgs.core.Operation;
import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.ArrayList;
import java.util.HashSet;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;


/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    @Ignore
    public void shouldQueryBeGeneratedCorrectly() throws GraphQLBuilderException {
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


        GraphQLBuilder builder = new GraphQLBuilder(Operation.Type.QUERY)
                .addRootField(new Field("allHeroesIn",
                        new HashSet<Argument>(asList(
                                new Argument("city", "New York, NY")
                        )),
                        new ArrayList<>(asList(
                                new Field("name"),
                                new Field("currentLocation"),
                                new Field("teamAffiliations", new ArrayList<>(asList(
                                        new Field("name")))
                                )))))
                .addRootField(new Field("allHeroes", new ArrayList<>(asList(new Field("name")))));

        String generatedQuery = builder.build();

        System.out.println(generatedQuery);


//        String generatedQuery = getSuperHeroesFrom("Paris").asString();
//        assertThat(expectedQuery, equalToIgnoringWhiteSpace(generatedQuery));
    }
}