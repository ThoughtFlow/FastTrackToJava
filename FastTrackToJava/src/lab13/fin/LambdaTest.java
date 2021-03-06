package lab13.fin;

import java.util.function.BiFunction;
import java.util.function.DoubleSupplier;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

public class LambdaTest {

	public static void main(String... args) {

		IntConsumer i1 = x -> { System.out.println(x * x); };
		i1.accept(3);

//		Function<Integer, Integer> f = x -> x * x;
		IntFunction<Integer> f2 = x -> x * x;
		System.out.println(f2.apply(3));

		BiFunction<Integer, Integer, Integer> i3 = (x, y) -> x * y;
		System.out.println(i3.apply(3, 3));

		DoubleSupplier i4 = () -> Math.PI;
		System.out.println(i4.getAsDouble());
		
		IntPredicate i5 = x -> x == 10;
		System.out.println(i5.test(10));
	}
}
