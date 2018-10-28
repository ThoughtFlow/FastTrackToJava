package chap08;

/**
 * This is a do-nothing implementation of the operation.
 *
 * @author nickmaiorano
 * @since 5
 */
public class DevNullOperation implements Operation {

    /**
     * {@inheritDoc}
     * 
     * Extra details about this implementation
     */
    @Override
    public void calculate(double operand) {
        // Do nothing
    }

    @Override
    public double getResult() {
        return 0;
    }
}
