package lab12.fin;

public class LambdaTest {

	private static void calculateAndConsume(int operand, Interface2 calculator, Interface4 consumer) {
		consumer.consume(calculator.getSquareOfA(operand));
	}

	public static void main(String... args) {

		// Define the lambda and invoke it.
		Interface1 i1 = x -> System.out.println(x * x);
		i1.printSquareOfA(3);

		// Need to instantiate the lambda to access the default instance method.
		Interface2 i2 = x -> x * x;
		System.out.println(i2.stringedSquareOfA(3));

		// No need to instantiate the lambda to access the static instance method.
		System.out.println(Interface3.defaultGetAxB(3, 3));

		// Using the method reference println as the implementation of Interface4
		Interface4 i4 = System.out::println;
		calculateAndConsume(3, i2, i4);
	}
}
