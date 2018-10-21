package chap03_inheritance;

class InnerA {
    String a = null;
    
    void doA() {
        System.out.println("A says " + a);
    }
}

class InnerB extends InnerA {
    String b = null;

    void doB() {
        System.out.println("B says " + b);
    }
}

class InnerC extends InnerB {
    String c = null;
    
    void doA() {
        System.out.println("Who cares what A says");
    }
    
    void doB() {
        System.out.println("Who cares what B says");
    }
    
    void doC() {
        System.out.println("C says " + a + " " + b + " " + c);
    }
}

public class InnerABCDemo {
	public static void main(String[] args) {
		InnerA a = new InnerA();
		InnerB b = new InnerB();
		InnerC c = new InnerC();

		a.a = "AAA";
		b.a = "B's A";
		b.b = "BBB";
		c.a = "Who cares";
		c.b = "Whatever";
		c.c = "CCC";

		a.doA();
		b.doB();
		c.doA();
		c.doB();
		c.doC();
	}
}
