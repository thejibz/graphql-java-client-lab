package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class InputObject implements IBuildable, Cloneable {
    private List<InputObjectField> inputObjectFields;

    @SafeVarargs
    public static InputObject object(InputObjectField... inputObjectFields) {
        return new InputObject(inputObjectFields);
    }

    @SafeVarargs
    public InputObject(InputObjectField... inputObjectFields) {
        this.inputObjectFields = asList(inputObjectFields);
    }

    public boolean add(InputObjectField inputObjectField) {
        return this.inputObjectFields.add(inputObjectField);
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        builder.append("{");
        InputObjectField[] inputObjectFields = this.inputObjectFields.toArray(new InputObjectField[0]);
        for (int i = 0; i < inputObjectFields.length; i++) {
            InputObjectField inputObjectField = inputObjectFields[i];
            inputObjectField.build(builder);
            if (i < inputObjectFields.length - 1) {
                builder.append(",");
            }
        }
        builder.append("}");
    }

    @Override
    public InputObject clone()  {
        InputObject inputObject = new InputObject();
        inputObject.inputObjectFields = new ArrayList<>(this.inputObjectFields);

        return inputObject;
    }
}
