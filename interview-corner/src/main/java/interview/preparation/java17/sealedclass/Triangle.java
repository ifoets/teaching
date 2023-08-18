package interview.preparation.java17.sealedclass;

public class Triangle {
    private final int base;
    private final int edge1;
    private final int edge2;
    private final int height;
    public Triangle(int base, int edge1, int edge2, int height) {
        this.base = base;
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.height = height;
    }
    public int getPerimeter() {
        return base + edge1 + edge2;
    }
    public int getArea() {
        return (base * height) / 2;
    }
}
