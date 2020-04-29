package poc.graphql.jaxgs.core;

public class InputObjectField {
    private String name;
    private Object value;

    public static InputObjectField prop(String name, Object value) {
        return new InputObjectField(name, value);
    }

    public InputObjectField(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
