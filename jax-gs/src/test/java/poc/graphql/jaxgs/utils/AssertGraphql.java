package poc.graphql.jaxgs.utils;

import graphql.parser.InvalidSyntaxException;
import graphql.parser.Parser;

import static org.junit.Assert.assertEquals;

public class AssertGraphql {
    public static void assertSameRequests(String expectedRequest, String actualRequest) {
        validateRequest(expectedRequest);
        validateRequest(actualRequest);

        /*
        Once requests have been deemed syntaxically correct, we can remove some tokens
        to actually be able to compare them without taking into account insignificant differences.
         */
        expectedRequest = unformatRequest(expectedRequest);
        actualRequest = unformatRequest(actualRequest);

        assertEquals(expectedRequest, actualRequest);
    }

    private static void validateRequest(String request) {
        Parser parser = new Parser();
        try {
            parser.parseDocument(request);
        } catch (InvalidSyntaxException e) {
            System.err.println(request);
            throw (e);
        }
    }

    private static String unformatRequest(String request) {
        return request
                .trim()
                .replaceAll("\\s+", "")
                .replaceAll(System.getProperty("line.separator"), "")
                .replaceAll(",", "");
    }
}
