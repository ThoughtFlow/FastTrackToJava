package chap13_3;

@FunctionalInterface
public interface AccountCreator {
    Account create(String accountId);
}
