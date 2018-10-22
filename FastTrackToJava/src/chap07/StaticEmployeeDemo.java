package chap07;

public class StaticEmployeeDemo {
    public static void main(String[] args) {
        // Change the company vacation policy
        StaticEmployee.setBaseVacationDays(15);
        StaticEmployee e2 = new StaticEmployee("Nick", "123456789");
        // Give a particular employee extra vacation
        e2.setExtraVacationDays(5);
        System.out.println("Employee vacation days: " + e2.getExtraVacationDays());
    }
}
