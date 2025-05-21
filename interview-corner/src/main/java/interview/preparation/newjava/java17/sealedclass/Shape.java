package interview.preparation.newjava.java17.sealedclass;

public sealed class Shape permits Square, Rectangle {
    protected int edge1, edge2;
    protected Shape(int edge1, int edge2) {
        this.edge1 = edge1;
        this.edge2 = edge2;
    }
}
