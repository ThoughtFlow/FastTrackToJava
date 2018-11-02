package lab12.init;

public class LambdaTest {

	private static void calculateAndConsume(int operand, Interface2 calculator, Interface4 consumer) {
		consumer.consume(calculator.getSquareOfA(operand));
	}

	public static void main(String... args) {

		// Define the lambda for interface1 and invoke it.

		// Define the lambda for interface2 and invoke its default method.

		// Invoke the static method of Interface3

		// Define the lambda for interface4 using a method reference and pass it to calculateAndConsume
	}
}
