package chap13_3;

@FunctionalInterface
public interface AccountArrayCreator {
    Account[] create(int value);
}
