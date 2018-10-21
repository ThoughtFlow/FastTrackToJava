package chap03_inheritance;

public class EmployeeDemo2 {
    public static void main(String[] args) {
        final Employee e1 = new Employee("John", "555-12-345");
        final Employee e2 = new Employee("Tom", "456-78-901");
        Employee em = new Manager("Bob", "345-11-987", "Development");

        Employee.setBaseVacationDays(15);
        e2.setExtraVacationDays(5);
        em.setExtraVacationDays(10);

        if (em instanceof Manager) {
            Manager m = (Manager) em;
            m.setResponsibility("Operations");
        }

        e1.print("COOL EMPLOYEE", null);
        e2.print("START OF EMPLOYEE", "END OF EMPLOYEE");
        em.print("BIG BOSS", null);
    }
}
