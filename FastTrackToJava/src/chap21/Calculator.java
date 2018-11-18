package chap21;

public class Calculator {
    public double squareRoot(double input) throws IllegalArgumentException {
        if (input < 0) {
            throw new IllegalArgumentException("No negatives: " + input);
        }
        return Math.sqrt(input);
    }
}
