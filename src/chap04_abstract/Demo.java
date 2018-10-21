package chap04_abstract;

public class Demo {
    public static void main(String[] args) {
        Circle a = new Circle(2);
        Circle b = new Circle(2);
        Circle c = a;
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }
}
