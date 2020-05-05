package poc.graphql.jaxgs.core;

import poc.graphql.jaxgs.exceptions.GraphQLBuilderException;

import java.util.LinkedHashMap;
import java.util.Map;

import static poc.graphql.jaxgs.utils.ValueFormatter.format;

public class InputObject implements IBuildable, Cloneable {
    private LinkedHashMap<String, Object> map = new LinkedHashMap();

    @SafeVarargs
    public static InputObject object(InputObjectField... inputObjectFields) {
        return new InputObject(inputObjectFields);
    }

    @SafeVarargs
    public InputObject(InputObjectField... m) {
        for (InputObjectField field : m) {
            this.map.put(field.getName(), field.getValue());
        }
    }

    private InputObject(LinkedHashMap map) {
        this.map = map;
    }

    @Override
    public void build(StringBuilder builder) throws GraphQLBuilderException {
        builder.append("{");
        int i = 0;
        for (Map.Entry<String, Object> entry : this.map.entrySet()) {
            builder.append(entry.getKey());
            builder.append(":");
            builder.append(format(entry.getValue()));
            if (i < this.map.entrySet().size() - 1) {
                builder.append(",");
            }
            i++;
        }
        builder.append("}");
    }

    @Override
    public InputObject clone() {
        return new InputObject((LinkedHashMap) this.map.clone());
    }

    public void add(InputObjectField prop) {
        this.map.put(prop.getName(), prop.getValue());
    }
}
