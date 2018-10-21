package chap03_inheritance;

public class EmployeeDemo {
    public static void main(String[] args) {
        Manager m1 = new Manager("Bob", "345-11-987", "Development");
        Employee.setBaseVacationDays(15);
        m1.setExtraVacationDays(10);
        m1.print("BIG BOSS", null);
    }
}
