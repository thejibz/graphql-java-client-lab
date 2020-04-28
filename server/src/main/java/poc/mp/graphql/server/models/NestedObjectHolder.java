package poc.mp.graphql.server.models;

public class NestedObjectHolder {
    private byte level;
    private String name;
    private Byte[] levelLineage;
    private NestedObjectHolder[] nestedObjectLineage;
    private NestedObjectHolder nestedObject;

    public NestedObjectHolder() {
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public NestedObjectHolder getNestedObject() {
        return nestedObject;
    }

    public void setNestedObject(NestedObjectHolder nestedObject) {
        this.nestedObject = nestedObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte[] getLevelLineage() {
        return levelLineage;
    }

    public void setLevelLineage(Byte[] levelLineage) {
        this.levelLineage = levelLineage;
    }

    public NestedObjectHolder[] getNestedObjectLineage() {
        return nestedObjectLineage;
    }

    public void setNestedObjectLineage(NestedObjectHolder[] nestedObjectLineage) {
        this.nestedObjectLineage = nestedObjectLineage;
    }
}
