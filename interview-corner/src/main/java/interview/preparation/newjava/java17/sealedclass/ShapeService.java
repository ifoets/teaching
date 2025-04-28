package interview.preparation.newjava.java17.sealedclass;

    public sealed interface ShapeService permits Square, Rectangle {
        default int getArea(int a, int b) {
            return a * b;
        }
        int getPerimeter();
    }
