package lab13.init;

import java.util.function.Function;

public class FunctionalComposition
{
    public static void main(String... args)
    {
    	// Define the 4 functions here

        // Compose using andThen()
    	Function<Integer, Integer> full = x -> x; // implement this
        System.out.println(full.apply(3));

        // Compose using compose()
    	full = x -> x; // implement this
        System.out.println(full.apply(3));
    }
}
