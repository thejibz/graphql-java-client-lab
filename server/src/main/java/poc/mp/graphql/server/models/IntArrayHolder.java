package poc.mp.graphql.server.models;

public class IntArrayHolder {
    private int[] intPrimitiveArray;
    private Integer[] intObjectArray;

    public IntArrayHolder() {
    }

    public int[] getIntPrimitiveArray() {
        return intPrimitiveArray;
    }

    public void setIntPrimitiveArray(int[] intPrimitiveArray) {
        this.intPrimitiveArray = intPrimitiveArray;
    }

    public Integer[] getIntObjectArray() {
        return intObjectArray;
    }

    public void setIntObjectArray(Integer[] intObjectArray) {
        this.intObjectArray = intObjectArray;
    }
}
