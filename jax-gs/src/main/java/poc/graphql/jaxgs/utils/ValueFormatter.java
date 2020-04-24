package poc.graphql.jaxgs.utils;

import java.lang.reflect.Array;
import java.time.LocalDate;

public class ValueFormatter {

    public static String format(Object value) {
        StringBuilder builder = new StringBuilder();

        if (value instanceof String) {
            _appendQuotedString(builder, (String) value);
        } else if (value instanceof LocalDate) {
            _appendQuotedString(builder, value.toString());
        } else if (value.getClass().isArray()) {
            builder.append("[");

            int length = Array.getLength(value);
            for (int i = 0; i < length; i++) {
                builder.append(format(Array.get(value, i)));
                if (i < length - 1) {
                    builder.append(", ");
                }
            }

            builder.append("]");
        } else {
            builder.append(value);
        }

        return builder.toString();
    }

    private static void _appendQuotedString(StringBuilder builder, String value) {
        builder.append('"');
        for (char c : value.toCharArray()) {
            switch (c) {
                case '"':
                case '\\':
                    builder.append('\\');
                    builder.append(c);
                    break;
                case '\r':
                    builder.append("\\r");
                    break;
                case '\n':
                    builder.append("\\n");
                    break;
                default:
                    if (c < 0x20) {
                        builder.append(String.format("\\u%04x", (int) c));
                    } else {
                        builder.append(c);
                    }
                    break;
            }
        }
        builder.append('"');
    }
}
