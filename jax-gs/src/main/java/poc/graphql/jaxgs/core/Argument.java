package poc.graphql.jaxgs.core;

public class Argument {
    private String name;
    private Object value;

    public static Argument arg(String name, Object value) {
        return new Argument(name, value);
    }

    public Argument(String name, Object value) {
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
