package lab01.fin;

public class CalculatorDemo3 {

	public static boolean isOperandValid(String operand) {
		return operand.matches("[0-9]*");
	}

	public static float getOperand(String operand) {
		return Float.parseFloat(operand);
	}

	public static void main(String[] args) {
		if (args.length % 2 != 1) {
			System.err.println("Usage: CalculatorDemo3 <<operand> <operator> <operand>> ...");
		}
		else if (isOperandValid(args[0])) {
			float result = getOperand(args[0]);

			for (int i = 1; i < args.length; i += 2) {

				char operator = args[i].charAt(0);
				if (isOperandValid(args[i + 1])) {
					float operand = getOperand(args[i + 1]);

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
					System.err.println("Invalid operand: " + args[i + 1]);
					return;
				}
			}
			System.out.println(result);
		}
		else {
			System.err.println("Invalid operand: " + args[0]);
		}
	}
}
