package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InputObject extends HashMap<String, Object> implements IBuildable {
    @SafeVarargs
    public static InputObject inputObject(InputField... m) {
        InputObject inputObject = new InputObject();
        for(InputField field : m) {
            inputObject.put(field.getKey(), field.getValue());
        }

        return inputObject;
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        builder.append("{");
        int i = 0;
        for (Map.Entry<String, Object> entry : Collections.unmodifiableSet(this.entrySet())) {
            InputField inputField = new InputField(entry.getKey(), entry.getValue());
            inputField.build(builder);
            if (i < this.size() - 1) {
                builder.append(", ");
            }
            i++;
        }
        builder.append("}");
    }
}
