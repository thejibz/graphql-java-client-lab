package poc.mp.graphql.server.models;

public class StringDoubleBoolHolder {
    private String aString;
    private double aDouble;
    private boolean aBool;

    public StringDoubleBoolHolder() {

    }

    public StringDoubleBoolHolder(String aString, double aDouble, boolean aBool) {
        this.aString = aString;
        this.aDouble = aDouble;
        this.aBool = aBool;
    }

    public String getString() {
        return aString;
    }

    public void setString(String aString) {
        this.aString = aString;
    }

    public double getDouble() {
        return aDouble;
    }

    public void setDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public boolean getBool() {
        return aBool;
    }

    public void setBool(boolean aBool) {
        this.aBool = aBool;
    }
}
