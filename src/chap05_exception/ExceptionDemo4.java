package chap05_exception;

public class ExceptionDemo4 {

    public static void main (String[] args) {
       divideSafely(args);
    }

    private static void divideSafely(String[] array) {
        try {
            System.out.println(divideArray(array));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: ExceptionDemo <num1> <num2>");
        } catch (NumberFormatException | ArithmeticException e) {
            System.err.println("Error: You are either specifying non-number or trying to / by zero");
        }
    }

    private static int divideArray(String[] array) {
        String s1 = array[0];
        String s2 = array[1];
        return divideStrings(s1, s2);
    }

    private static int divideStrings(String s1, String s2) {
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        return divideInts(i1, i2);
    }

    private static int divideInts(int i1, int i2) {
        return i1 / i2;
    }
}
