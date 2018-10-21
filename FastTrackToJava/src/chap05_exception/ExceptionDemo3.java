package chap05_exception;

public class ExceptionDemo3 {

    public static void main (String[] args) {
       divideSafely(args);
    }

    private static void divideSafely(String[] array) {
        try {
            System.out.println(divideArray(array));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: ExceptionDemo <num1> <num2>");
        }
    }

    private static int divideArray(String[] array) {
        String s1 = array[0];
        String s2 = array[1];
        return divideStrings(s1, s2);
    }

    private static int divideStrings(String s1, String s2) {
        try {
            int i1 = Integer.parseInt(s1);
            int i2 = Integer.parseInt(s2);
            return divideInts(i1, i2);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static int divideInts(int i1, int i2) {
        try {
            return i1 / i2;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}
