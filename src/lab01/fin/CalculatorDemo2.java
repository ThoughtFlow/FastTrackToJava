package lab01.fin;

public class CalculatorDemo2 {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("Usage: CalculatorDemo2 <operator> <operand>...");
		} 
		else {
			char operator = args[0].charAt(0);
			if (args[1].matches("[0-9]*")) {
				float result = Float.parseFloat(args[1]);
				for (int i = 2; i < args.length; i++) {

					if (args[i].matches("[0-9]*")) {

						float operand = Float.parseFloat(args[i]);
						switch (operator) {
						case '+':
							result += operand;
							break;
						case '-':
							result -= operand;
							break;
						case '*':
							result *= operand;
							break;
						case '/':
							result /= operand;
							break;
						default:
							System.err.println("Unknown operator: " + operator);
							return;
						}
					}
					else {
						System.err.println("Invalid operand: " + args[i]);
					}
				}
				System.out.println(result);
			}
			else {
				System.err.println("Invalid operand: " + args[1]);
			}
		}
	}
}