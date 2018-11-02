package lab12.fin;

@FunctionalInterface
public interface Interface3 {

	public int getAxB(int a, int b);
	
	static int defaultGetAxB(int a, int b) {
		return a * b;
	}
}
