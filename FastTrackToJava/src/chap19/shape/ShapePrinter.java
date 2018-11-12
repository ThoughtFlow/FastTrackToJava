package chap19.shape;

public class ShapePrinter {

    /**
     * Prints a shape.
     * @param shape the shape to be printed.
     * @throws NullPointerException if shape is null.
     */
    public void print(Shape shape) {
        System.out.println("AREA: " +
                shape.getArea());
        System.out.println("PERIMETER: " +
                shape.getPerimeter());
    }

}
